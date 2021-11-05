# TikalMessagingAppExercise

API:

● Send message - GET

http://localhost:8080/messages/{recipient_name}

● Receive messages - POST

http://localhost:8080/messages

Body:

{
    "sender" : "{sender_name}",
    "recipient" : "{recipient_name}",
    "msgContent" : "{message_content}"
}
