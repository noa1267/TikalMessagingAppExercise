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



-----------------
*At first I created a User Object, with id, name, email, etc. But for simplicity I cancel it and used only names. I assume that sender and recipient names are unique, like userName at other platforms.
