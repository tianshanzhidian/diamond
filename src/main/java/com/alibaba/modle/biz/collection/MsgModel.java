package com.alibaba.modle.biz.collection;

import com.pamirs.data.cloud.sink.MessageEntity;
import com.pamirs.data.cloud.sink.rule.TableTask;
import com.pamirs.mq.client.serialize.ISerializer;

public class MsgModel {
    private MessageEntity messageEntity;
    private byte[] data;
    private TableTask tableTask;
    private ISerializer<MessageEntity> iSerializer;
    private String mqId;

    public MsgModel(MessageEntity messageEntity, ISerializer<MessageEntity> iSerializer, TableTask tableTask) {
        this.messageEntity = messageEntity;
        this.tableTask = tableTask;
        this.iSerializer = iSerializer;
    }

    public MsgModel() {
    }

    public String getMqId() {
        return mqId;
    }

    public void setMqId(String mqId) {
        this.mqId = mqId;
    }

    public ISerializer<MessageEntity> getiSerializer() {
        return iSerializer;
    }

    public void serializer() {
        data = iSerializer.serialize(messageEntity);
    }

    public TableTask getTableTask() {
        return tableTask;
    }

    public void setTableTask(TableTask tableTask) {
        this.tableTask = tableTask;
    }

    public MessageEntity getMessageEntity() {
        return messageEntity;
    }

    public void setMessageEntity(MessageEntity messageEntity) {
        this.messageEntity = messageEntity;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
