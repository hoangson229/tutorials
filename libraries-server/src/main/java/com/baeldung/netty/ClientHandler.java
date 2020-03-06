package com.baeldung.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    RequestData msg;
    ResponseData responseData;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
        responseData = (ResponseData) msg;
        ctx.close();
    }

    public ClientHandler(RequestData msg) {
        this.msg = msg;
    }

    public RequestData getMsg() {
        return msg;
    }

    public void setMsg(RequestData msg) {
        this.msg = msg;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
}
