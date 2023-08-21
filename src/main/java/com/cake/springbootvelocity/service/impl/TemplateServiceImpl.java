package com.cake.springbootvelocity.service.impl;

import com.cake.springbootvelocity.service.TemplateService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;

import java.io.StringWriter;

public class TemplateServiceImpl implements TemplateService {
    @Override
    public String process() {

        Velocity.init();

        // Create a template string
        String templateString = "Hello ${name}! Welcome to MadMobile Loyalty.";

        // Create a context and add data
        VelocityContext context = new VelocityContext();
        context.put("name", "John");

        // Process the template
        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "templateString", templateString);

        // Return the processed template as a String
        return writer.toString();
    }
}
