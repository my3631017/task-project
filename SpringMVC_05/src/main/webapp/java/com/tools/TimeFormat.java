package com.tools;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class TimeFormat extends TagSupport {
    private static final long serialVersionUID = -8683014812426654300L;
    private String value;//要转换的Long类型时间
    private String pattern;//要转换的对应格式

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

//    重写父类方法
    public int doStartTag() throws JspException {
        Long time = Long.valueOf(value);
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String t = dateFormat.format(time);
        try {
            pageContext.getOut().write(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

}