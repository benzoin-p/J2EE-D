package com.example.emall.result;

import lombok.Data;

//返回结果
@Data
public class Result {

    private String code;
    private String message;
    private Object data;
    private boolean success;

    //正常返回数据
    public static Result success(Object o)
    {
        Result result=new Result();
        result.setCode("200");
        result.setMessage("成功");
        result.setData(o);
        result.setSuccess(true);
        return result;
    }

    //带有自定义信息的返回
    public static Result success(Object o,String message)
    {
        Result result=new Result();
        result.setCode("200");
        result.setMessage(message);
        result.setData(o);
        result.setSuccess(true);
        return result;
    }

    //返回成功但未找到数据，需在前端进行处理（如使用默认图片或文字）
    public static Result nullSuccess()
    {
        Result result=new Result();
        result.setCode("200");
        result.setMessage("成功");
        result.setData(null);
        result.setSuccess(true);
        return result;
    }

    //返回失败
    public static Result fail(String code,String message)
    {
        Result result=new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

    //不返回相关结果，仅提示返回成功，用于前端选择
    public static Result inform(String message)
    {
        Result result=new Result();
        result.setCode("200");
        result.setMessage(message);
        result.setData("成功");
        result.setSuccess(true);
        return result;
    }

}
