package com.example.redmedicine.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class SmsService {

    @Value("${smsservice.serviceId}")
    String serviceId;
    @Value("${smsservice.accessKey}")
    String accessKey;
    @Value("${smsservice.secretKey}")
    String secretKey;
    String method = "POST";
    String timeStamp = Long.toString(System.currentTimeMillis());


    //비밀번호찾기 인증번호, 회원가입 인증번호
    public Map<String, Object> sendMessage(String phoneNumber){
        String requestUrl = "/sms/v2/services/" + serviceId + "/messages";
        String apiUrl = "https://sens.apigw.ntruss.com" + requestUrl;

        Map<String, String> message = new HashMap<>();
        message.put("to", phoneNumber);

        String authNumber = makeAuthNumber();

        List<Map> messages = List.of(message);

        Map<String, Object> body = new HashMap<>();
        body.put("content","인증번호(6자리) : "+ authNumber);
        body.put("type", "SMS");
        body.put("from", "01092240273");
        body.put("messages", messages);

        WebClient webClient = null;


        try {
            webClient = WebClient.builder()
                    .baseUrl(apiUrl)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
                    .defaultHeader("x-ncp-apigw-timestamp", timeStamp)
                    .defaultHeader("x-ncp-iam-access-key", accessKey)
                    .defaultHeader("x-ncp-apigw-signature-v2", makeSignature())
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        Mono<Map> resultBody = webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(Map.class);

        Map<String, Object> result = new HashMap<>();
        result.put("mono", resultBody);
        result.put("authNumber", authNumber);

        return result;
    }

    ////상담예약 내역 문자 전송
    public Map<String, Object> sendBookMsg(String phoneNumber,String smsContent){
        String requestUrl = "/sms/v2/services/" + serviceId + "/messages";
        String apiUrl = "https://sens.apigw.ntruss.com" + requestUrl;

        Map<String, String> message = new HashMap<>();
        message.put("to", phoneNumber);

        List<Map> messages = List.of(message);

        Map<String, Object> body = new HashMap<>();
        body.put("content",smsContent);
        body.put("type", "SMS");
        body.put("from", "01092240273");
        body.put("messages", messages);

        WebClient webClient = null;


        try {
            webClient = WebClient.builder()
                    .baseUrl(apiUrl)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
                    .defaultHeader("x-ncp-apigw-timestamp", timeStamp)
                    .defaultHeader("x-ncp-iam-access-key", accessKey)
                    .defaultHeader("x-ncp-apigw-signature-v2", makeSignature())
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        Mono<Map> resultBody = webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(Map.class);

        Map<String, Object> result = new HashMap<>();
        result.put("mono", resultBody);

        return result;
    }

    private String makeSignature() throws NoSuchAlgorithmException, InvalidKeyException {
        String requestUrl = "/sms/v2/services/" + serviceId + "/messages";
        String apiUrl = "https://sens.apigw.ntruss.com" + requestUrl;

        String message = new StringBuilder()
                .append(method)
                .append(" ")
                .append(requestUrl)
                .append("\n")
                .append(timeStamp)
                .append("\n")
                .append(accessKey)
                .toString();

        SecretKeySpec secretKeySpec = null;
        String encBase64 = null;
        Mac mac = null;

        secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        encBase64 = Base64.getEncoder().encodeToString(rawHmac);

        return encBase64;
    }


    private String makeAuthNumber(){
        Random random = new Random();
        String authNumber = "";

        for(int i=0; i<6; i++){
            authNumber += random.nextInt(10);
        }

        return authNumber;
    }
}
