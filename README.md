# MONGO DB PROJECT
* Spring Boot 3
* Java 19
* Maven
* Docker 
* MongoDB

`mongo.db.name=test` -> create test collection first   
`server.port=8080`  
`mongo.port=27017` 

## ENDPOINTS
_____________________________
## CUSTOMERS

### (POST) register customer
`http://localhost:8080/api/customers`   

_Request Body (JSON)_  
```
{    
    "firstName": "Jose",       
    "lastName": "Lozada",
    "phone": "73097389",
    "address": {
        "city": "La Paz",
        "zone": "south",
        "street": "street five"
    }
}
```
### (GET) get customer by city
`http://localhost:8080/api/customers/city?city=La Paz`   

| Query Params |        |
|--------------|--------|
| city         | La Paz | 

Query Params
city
La Paz

### (GET) get all customers
`http://localhost:8080/api/customers`      

### (DELETE) delete by id
`http://localhost:8080/api/customers/653d7f69f771c172cbd0e648`    

_____________________________
## SALES

### (POST) register sale
`http://localhost:8080/api/sales`   

Request Body (JSON)
```
{
    "customer": {
        "id": "653e4c50d1265658c1ad6a21"
    },
    "item": "backpack",
    "amount": 100
}
```
### (GET) get sale by item
`http://localhost:8080/api/sales/item?item=backpack`

| Query Params |              |
|--------------|--------------|
| item         | backpack     | 

### (GET) get sale by customer name
`http://localhost:8080/api/sales/customer?name=Jose Lozada`

| Query Params |             |
|--------------|-------------|
| name         | Jose Lozada | 

### (GET) get total amount by item
`http://localhost:8080/api/sales/item/total_amount?item=backpack`

| Query Params |              |
|--------------|--------------|
| item         | backpack     | 

### (GET) get total amount by customer name

| Query Params |             |
|--------------|-------------|
| name         | Jose Lozada | 