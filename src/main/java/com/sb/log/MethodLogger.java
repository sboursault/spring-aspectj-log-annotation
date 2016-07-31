package com.sb.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by sboursault on 6/25/16.
 */
@Aspect
@Component
public class MethodLogger {

  @Before("@annotation(LogInfo)")
  public void before(JoinPoint point) {

    MethodSignature signature = (MethodSignature) point.getSignature();

    String message = signature.getMethod().getAnnotation(LogInfo.class).value();

    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression(message);

    StandardEvaluationContext context = new StandardEvaluationContext();

    for (int i = 0; i < signature.getParameterNames().length; i++) {
      context.setVariable(signature.getParameterNames()[i], point.getArgs()[i]);
    }

    String log = (String) exp.getValue(context);

    System.out.println(log);
  }
}