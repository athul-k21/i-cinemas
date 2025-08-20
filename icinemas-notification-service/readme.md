## Testing Steps

### 1) Either bring up Kafka server or Invoke Rest endpoint

#### A) Start Zookeeper & Kafka Servers
Navigate Kafka directory and execute below commands to bring up Zookeeper & Kafka servers respectively

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties

#### B) Alternatively invoke below Rest endpoint
curl -X POST http://localhost:8080/api/v1/notification/send \
-H "Content-Type: application/json" \
-d '{
"email": "user@example.com",
"type": "BOOKING_CONFIRMED",
"remarks": "Your seat numbers are A1, A2",
"transactionId": "TXN123",
"userId": "U1"
}'

### 2) Make sure to update properties with email account and app password
App Password can be generated from gmail account [ This is not gmail password ]