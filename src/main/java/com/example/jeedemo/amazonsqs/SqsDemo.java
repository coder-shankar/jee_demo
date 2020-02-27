package com.example.jeedemo.amazonsqs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.jeedemo.property.Property;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class SqsDemo {

    @Inject
    @Property("aws.sqs.client.id")
    private String awsClientId;

    @Inject
    @Property("aws.sqs.client.secret")
    private String awsClientSecret;

    @Inject
    @Property("amazon.sqs.region")
    private String region;

    @Inject
    @Property("aws.sqs.queue.url")
    private String queueUrl;

    private AmazonSQS getSqsClient() {
        AWSCredentials credentials = new BasicAWSCredentials(awsClientId, awsClientSecret);
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(region)
            .build();

        return sqs;
    }

    private void enqueue(String message) {
//        https://sqs.us-east-1.amazonaws.com/377871494486/test-raasV2-sqs
        SendMessageRequest request = new SendMessageRequest()
            .withQueueUrl(queueUrl)
            .withMessageBody(message);

        getSqsClient().sendMessage(request);
    }

    private List<Message> list() {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        List<Message> receiveMessageResult = getSqsClient()
            .receiveMessage(receiveMessageRequest).getMessages();

        return receiveMessageResult;
    }

    private void dequeue (List<Message> messages) {
        messages.forEach(message -> getSqsClient().deleteMessage(queueUrl, message.getReceiptHandle()));
    }
}
