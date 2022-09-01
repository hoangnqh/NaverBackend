# PROJECT 1 - week 3.1
Ecommerce Management
1. [Init data and insert into database](#1-Init-data-and-insert-into-database)

	1.1 [Init Customer](#Init-Customer)
	
	1.2 [Init product](#Init-product)
	
	
2. [Get product with condition](#2-Get-product-with-condition)

	2.1 [LESS_THAN](#2.1-LESS_THAN)
	
	2.2 [GREATER_THAN](#2.2-GREATER_THAN)
	
	2.3 [EQUAL](#2.3-EQUAL)
	
	
3. [Add item](#3-Add-item)

	[Handle the case where customer id is not exists](#Handle-the-case-where-customer-id-is-not-exists)
	
	[Handle the case where product id is not exists](#Handle-the-case-where-product-id-is-not-exists)


4. [Update the item if it already exists, otherwise add item](#4-Update-the-item-if-it-already-exists-otherwise-add-item)
	
	
5. [Get item info list by parameter](#5-Get-item-info-list-by-parameter)

## 1 Init data and insert into database
This project uses H2 database
### Init Customer
Request

GET /api/v1/get-all-customer

Response
```
[
    {
        "id": 1,
        "name": "Huy Hoang 1",
        "address": "a",
        "phoneNo": "1"
    },
    {
        "id": 2,
        "name": "Huy Hoang 2",
        "address": "b",
        "phoneNo": "2"
    },
    {
        "id": 3,
        "name": "Huy Hoang 3",
        "address": "c",
        "phoneNo": "3"
    },
    {
        "id": 4,
        "name": "Huy Hoang 4",
        "address": "d",
        "phoneNo": "4"
    },
    {
        "id": 5,
        "name": "Huy Hoang 5",
        "address": "e",
        "phoneNo": "5"
    }
]
```
### Init product
Request

GET /api/v1/get-all-product

Response
```
[
    {
        "id": 1,
        "nameProduct": "product1",
        "type": "1",
        "size": "1",
        "quantity": 5,
        "price": 23145.00
    },
    {
        "id": 2,
        "nameProduct": "product2",
        "type": "12",
        "size": "12",
        "quantity": 5,
        "price": 41325.00
    },
    {
        "id": 3,
        "nameProduct": "product3",
        "type": "13",
        "size": "13",
        "quantity": 5,
        "price": 144325.00
    },
    {
        "id": 4,
        "nameProduct": "product4",
        "type": "14",
        "size": "14",
        "quantity": 5,
        "price": 14655.00
    },
    {
        "id": 5,
        "nameProduct": "product5",
        "type": "15",
        "size": "15",
        "quantity": 5,
        "price": 14574.00
    },
    {
        "id": 6,
        "nameProduct": "product6",
        "type": "16",
        "size": "16",
        "quantity": 5,
        "price": 145536.00
    },
    {
        "id": 7,
        "nameProduct": "product7",
        "type": "17",
        "size": "17",
        "quantity": 5,
        "price": 53145.00
    },
    {
        "id": 8,
        "nameProduct": "product8",
        "type": "18",
        "size": "18",
        "quantity": 5,
        "price": 54145.00
    },
    {
        "id": 9,
        "nameProduct": "product9",
        "type": "19",
        "size": "19",
        "quantity": 5,
        "price": 144365.00
    },
    {
        "id": 10,
        "nameProduct": "product10",
        "type": "10",
        "size": "10",
        "quantity": 5,
        "price": 12445.00
    },
    {
        "id": 11,
        "nameProduct": "product10",
        "type": "11",
        "size": "11",
        "quantity": 5,
        "price": 22445.00
    },
    {
        "id": 12,
        "nameProduct": "product10",
        "type": "12",
        "size": "12",
        "quantity": 5,
        "price": 27445.00
    },
    {
        "id": 13,
        "nameProduct": "product10",
        "type": "13",
        "size": "13",
        "quantity": 5,
        "price": 27445.00
    },
    {
        "id": 14,
        "nameProduct": "product10",
        "type": "14",
        "size": "14",
        "quantity": 5,
        "price": 27445.00
    },
    {
        "id": 15,
        "nameProduct": "product10",
        "type": "15",
        "size": "15",
        "quantity": 5,
        "price": 27445.00
    }
]
```


## 2 Get product with condition 
### 2.1 LESS_THAN

Request

GET /api/v1/price-condition
```
{
	"price": 144325,
	"condition": "LESS_THAN"
}
```
Response
```
[
    {
        "id": 1,
        "nameProduct": "product1",
        "type": "1",
        "size": "1",
        "quantity": 5,
        "price": 23145.00
    },
    {
        "id": 2,
        "nameProduct": "product2",
        "type": "12",
        "size": "12",
        "quantity": 5,
        "price": 41325.00
    },
    {
        "id": 4,
        "nameProduct": "product4",
        "type": "14",
        "size": "14",
        "quantity": 5,
        "price": 14655.00
    },
    {
        "id": 5,
        "nameProduct": "product5",
        "type": "15",
        "size": "15",
        "quantity": 5,
        "price": 14574.00
    },
    {
        "id": 7,
        "nameProduct": "product7",
        "type": "17",
        "size": "17",
        "quantity": 5,
        "price": 53145.00
    },
    {
        "id": 8,
        "nameProduct": "product8",
        "type": "18",
        "size": "18",
        "quantity": 5,
        "price": 54145.00
    },
    {
        "id": 10,
        "nameProduct": "product10",
        "type": "10",
        "size": "10",
        "quantity": 5,
        "price": 12445.00
    }
]
```

### 2.2 GREATER_THAN
Request

GET /api/v1/price-condition
```
{
	"price": 144325,
	"condition": "GREATER_THAN"
}
```
Response
```
[
    {
        "id": 6,
        "nameProduct": "product6",
        "type": "16",
        "size": "16",
        "quantity": 5,
        "price": 145536.00
    },
    {
        "id": 9,
        "nameProduct": "product9",
        "type": "19",
        "size": "19",
        "quantity": 5,
        "price": 144365.00
    }
]
```
### 2.3 EQUAL
Request

GET /api/v1/price-condition
```
{
	"price": 144325,
	"condition": "EQUAL"
}
```
Response
```
[
    {
        "id": 3,
        "nameProduct": "product3",
        "type": "13",
        "size": "13",
        "quantity": 5,
        "price": 144325.00
    }
]
```
## 3 Add item
Request

POST /api/v1/update-new-item
```
{
	"customerId": 1,
	"productId": 2,
	"quantity": 2
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 1,
            "productId": 2
        },
        "quantityWished": 2,
        "dateAdded": "2022-09-01T04:58:55.167+00:00",
        "totalAmount": 82650.00
    }
}
```
### Handle the case where customer id is not exists
Request

POST /api/v1/update-new-item
```
{
    "customerId": 15,
    "productId": 2,
    "quantity": 3
}
```
Response
```
{
    "status": "failed",
    "message": "Customer id is not exists",
    "data": ""
}
```
### Handle the case where product id is not exists
Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 16,
    "quantity": 3
}
```
Response
```
{
    "status": "failed",
    "message": "Product id is not exists",
    "data": ""
}
```
## 4 Update the item if it already exists otherwise add item
Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 10,
    "quantity": 3
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 2,
            "productId": 10
        },
        "quantityWished": 3,
        "dateAdded": "2022-09-01T04:59:30.912+00:00",
        "totalAmount": 37335.00
    }
}
```

Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 10,
    "quantity": 6
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 2,
            "productId": 10
        },
        "quantityWished": 9,
        "dateAdded": "2022-09-01T04:59:42.988+00:00",
        "totalAmount": 112005.00
    }
}
```

Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 10,
    "quantity": 6
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 2,
            "productId": 10
        },
        "quantityWished": 15,
        "dateAdded": "2022-09-01T04:59:58.216+00:00",
        "totalAmount": 186675.00
    }
}
```

Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 11,
    "quantity": 6
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 2,
            "productId": 11
        },
        "quantityWished": 6,
        "dateAdded": "2022-09-01T05:00:13.483+00:00",
        "totalAmount": 134670.00
    }
}
```

Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 12,
    "quantity": 6
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 2,
            "productId": 12
        },
        "quantityWished": 6,
        "dateAdded": "2022-09-01T05:00:33.272+00:00",
        "totalAmount": 164670.00
    }
}
```

Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 13,
    "quantity": 6
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 2,
            "productId": 13
        },
        "quantityWished": 6,
        "dateAdded": "2022-09-01T05:00:45.511+00:00",
        "totalAmount": 164670.00
    }
}
```

Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 14,
    "quantity": 6
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 2,
            "productId": 14
        },
        "quantityWished": 6,
        "dateAdded": "2022-09-01T05:00:56.270+00:00",
        "totalAmount": 164670.00
    }
}
```

Request

POST /api/v1/update-new-item
```
{
    "customerId": 5,
    "productId": 15,
    "quantity": 6
}
```
Response
```
{
    "status": "Success",
    "message": "Add item success",
    "data": {
        "id": {
            "cartId": 2,
            "productId": 15
        },
        "quantityWished": 6,
        "dateAdded": "2022-09-01T05:01:11.783+00:00",
        "totalAmount": 164670.00
    }
}
```


## 5 Get item info list by parameter
Request

GET /api/v1/info-cart-item
```
{
    "customerId": 5,
    "nameProduct": "product10",
    "offset": 2,
    "limit": 3
}
```
Response
```
{
    "status": "ok",
    "message": "ok",
    "data": [
        {
            "cartId": 2,
            "productId": 12,
            "nameProduct": "product10",
            "type": "12",
            "size": "12",
            "quantity": 6,
            "price": 27445.00,
            "totalAmount": 164670.00,
            "dateAdded": "2022-09-01T05:00:33.272+00:00"
        },
        {
            "cartId": 2,
            "productId": 13,
            "nameProduct": "product10",
            "type": "13",
            "size": "13",
            "quantity": 6,
            "price": 27445.00,
            "totalAmount": 164670.00,
            "dateAdded": "2022-09-01T05:00:45.511+00:00"
        },
        {
            "cartId": 2,
            "productId": 14,
            "nameProduct": "product10",
            "type": "14",
            "size": "14",
            "quantity": 6,
            "price": 27445.00,
            "totalAmount": 164670.00,
            "dateAdded": "2022-09-01T05:00:56.270+00:00"
        }
    ]
}
```

Request

GET /api/v1/info-cart-item
```
{
    "customerId": 5,
    "nameProduct": "product10",
    "offset": 3,
    "limit": 2
}
```
Response
```
{
    "status": "ok",
    "message": "ok",
    "data": [
        {
            "cartId": 2,
            "productId": 13,
            "nameProduct": "product10",
            "type": "13",
            "size": "13",
            "quantity": 6,
            "price": 27445.00,
            "totalAmount": 164670.00,
            "dateAdded": "2022-09-01T05:00:45.511+00:00"
        },
        {
            "cartId": 2,
            "productId": 14,
            "nameProduct": "product10",
            "type": "14",
            "size": "14",
            "quantity": 6,
            "price": 27445.00,
            "totalAmount": 164670.00,
            "dateAdded": "2022-09-01T05:00:56.270+00:00"
        }
    ]
}
```

Request

GET /api/v1/info-cart-item
```
{
    "customerId": 1,
    "nameProduct": "product2",
    "offset": 1,
    "limit": 2
}
```
Response
```
{
    "status": "ok",
    "message": "ok",
    "data": []
}
```