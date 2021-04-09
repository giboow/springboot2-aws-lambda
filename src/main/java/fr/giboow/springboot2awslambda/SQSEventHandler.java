package fr.giboow.springboot2awslambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SQSEventHandler implements RequestHandler<SQSEvent, Void> {

    @Override
    public Void handleRequest(SQSEvent event, Context context) {

        for(SQSEvent.SQSMessage message : event.getRecords()) {
//            message.
            log.info(message.getBody());
        }

        return null;
    }
}
