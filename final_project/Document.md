**Outline**

[TOC]

---



# Dealer

| Member Name | Type                 | Description                 |
| ----------- | -------------------- | --------------------------- |
| id          | String               | unique id of a dealer       |
| name        | String               | name of a dealer            |
| address     | Address              | address of a dealer         |
| vehicles    | ArrayList\<Vehicle\> | all vehicles a dealer owns  |
| specials    | ArrayList\<Special\> | all special a dealer offers |

​       Methods : // todo



## Address

**Address is a inner class of Dealer Class**

| Member Name | Type   | Description          |
| ----------- | ------ | -------------------- |
| address1    | String | address1 of a dealer |
| address2    | String | address2 of a dealer |
| city        | String | city                 |
| state       | String | state                |
| zipCode     | String | zip code             |

Methods : // todo



# Vehicle

| Member Name   | Type                      | Description                                   |
| ------------- | ------------------------- | --------------------------------------------- |
| id            | String                    | unique id of a vehicle                        |
| dealerName    | String                    | name of a vehicle's dealer                    |
| year          | String                    | year of a vehicle                             |
| make          | String                    | brand of a vehicle                            |
| model         | String                    | model of a vehicle                            |
| type          | boolean                   | true for new, false for used                  |
| price         | String                    | price of a vehicle                            |
| exteriorColor | String                    | exterior color                                |
| interiorColor | String                    | interior color                                |
| bodyType      | BodyType                  | VAN, SUV, Jeep                                |
| features      | ArrayList\<String\>       | features of a vehicle                         |
| miles         | String                    | miles                                         |
| images        | ArrayList\<VehicleImage\> | images of a vehicle                           |
| specials      | ArrayList\<Special\>      | specials that may be applicable for a vehicle |

Methods : // todo



## BodyType

 **a enum class, only contains 3 values (VAN, SUV, Jeep).**



# Special

| Member Name | Type             | Description                  |
| ----------- | ---------------- | ---------------------------- |
| id          | String           | unique id of a special       |
| startDate   | String           | start date of a special      |
| endDate     | String           | end date of a special        |
| title       | String           | special title                |
| description | String           | description of a special     |
| type        | boolean          | true for new, false for used |
| disclaimer  | String           | disclaimer of a special      |
| criterion   | VehicleCriterion | criterion for a special      |

Methods : // todo



## VehicleCriterion

| Member Name | Type                | Description                |
| ----------- | ------------------- | -------------------------- |
| make        | String              | a special for some make    |
| model       | String              | a special for some model   |
| year        | String              | a special for some year    |
| minPrice    | String              | special minPrice           |
| maxPrice    | String              | special maxPrice           |
| vehicleIds  | ArrayList\<String\> | a special for vehicale ids |

Methods : // todo

