# PROJECT 2 - week 5.2

## Final project


GET /api/v1/currency-calculation/from/{from}/to/{to}/amount/{amount}

### RestTemplate

Example 1:

Request
```
http://localhost:8765/api/v1/currency-calculation/from/EUR/to/VND/amount/50
```
Response
```
{
    "status": "OK",
    "message": "OK",
    "data": {
        "id": 10002,
        "from": "EUR",
        "to": "VND",
        "conversionMultiple": 23800.00,
        "quantity": 50,
        "port": 8000,
        "totalCalculatedAmount": 1190000.00
    }
}
```

Example 2:

Request
```
http://localhost:8765/api/v1/currency-calculation/from/EUR/to/VND/amount/20
```
Response
```
{
    "status": "OK",
    "message": "OK",
    "data": {
        "id": 10002,
        "from": "EUR",
        "to": "VND",
        "conversionMultiple": 23800.00,
        "quantity": 20,
        "port": 8001,
        "totalCalculatedAmount": 476000.00
    }
}
```



**Note: In example 1 port=8000, but in example 2 port=8001 => this is load balancer**


Example 3:

Request
```
http://localhost:8765/api/v1/currency-calculation/from/USD/to/VND/amount/18
```
Response
```
{
    "status": "OK",
    "message": "OK",
    "data": {
        "id": 10001,
        "from": "USD",
        "to": "VND",
        "conversionMultiple": 23300.00,
        "quantity": 18,
        "port": 8000,
        "totalCalculatedAmount": 419400.00
    }
}
```

### Feign Client

Example 4:

Request
```
http://localhost:8765/api/v1/currency-calculation/feign/from/USD/to/VND/amount/18
```
Response
```
{
    "status": "OK",
    "message": "OK",
    "data": {
        "id": 10001,
        "from": "USD",
        "to": "VND",
        "conversionMultiple": 23300.00,
        "quantity": 18,
        "port": 8000,
        "totalCalculatedAmount": 419400.00
    }
}
```

Example 5:

Request
```
http://localhost:8765/api/v1/currency-calculation/feign/from/EUR/to/VND/amount/34
```
Response
```
{
    "status": "OK",
    "message": "OK",
    "data": {
        "id": 10002,
        "from": "EUR",
        "to": "VND",
        "conversionMultiple": 23800.00,
        "quantity": 34,
        "port": 8001,
        "totalCalculatedAmount": 809200.00
    }
}
```