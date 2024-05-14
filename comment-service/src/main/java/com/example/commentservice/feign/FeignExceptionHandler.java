package com.example.commentservice.feign;

import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

@Component
public class FeignExceptionHandler implements ErrorDecoder {

    // вызывается каждый раз при ошибке вызова через Feign
    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()) {
            case 406: {
                return new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, readMessage(response));
            }
        }

        return null;
    }

    // получить текст ошибки в формате String из потока
    private String readMessage(Response response) {

        String message = null;
        Reader reader = null;

        try {

            reader = response.body().asReader(Charset.defaultCharset());
            message = CharStreams.toString(reader);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return message;
    }

}


