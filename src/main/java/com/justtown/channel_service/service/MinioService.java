package com.justtown.channel_service.service;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class MinioService {

    @Autowired
    private final MinioClient minioClient;
    @Value("${minio.get-bucket}")
    private String getBucket;
    @Value("${minio.post-bucket}")
    private String postBucket;

    public String generateGetURL(String filename) {
        try {
            return generateURL(filename, Method.GET);
        } catch (MinioException e) {
            return "";
        }
    }

    public String generatePostURL(String filename) throws MinioException {
        return generateURL(filename, Method.PUT);
    }

    private String generateURL(String filename, Method method) throws MinioException {
        String bucket = method.equals(Method.GET) ? getBucket : postBucket;
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(method)
                            .bucket(bucket)
                            .object(filename)
                            .expiry(30, TimeUnit.MINUTES)
                            .build()
            );
        } catch (Exception e) {
            throw new MinioException();
        }
    }
}
