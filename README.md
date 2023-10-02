This project uses following spring concepts:

1 - Exception handling 

2 - Mapper Struct 

3 - Validation

4 - Logging 

5 - Send Grid integration

6 - Aspect Oriented Programming using AspectJ 

7 - Object Relationships - One to Many - Bill to Devices 
                           One to One - Bill to Address

8 - Jpa and Hibernate 

9 - Postgre Database


Problem - 

In bi-directional mapping from BillEntity to DeviceEntity i.e. one to many realationship and many to one realtionship respectively creates a foreign key bill_fk which is having a null value 

<img width="389" alt="Screenshot 2023-10-02 160936" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/2d96bea2-8886-4c52-b25e-97a07bfeda9e">





Hibernate is creating foreign key but the column has null value as shown above. Following queries are written by Hibernate

<img width="842" alt="Screenshot 2023-10-02 161127" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/63b7f163-328b-4f74-8ae4-1e45c19495b5">


...........................................................................................................................................................


<img width="579" alt="Screenshot 2023-10-02 161146" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/54dc90b1-5236-4497-8d8f-2d18c0ebc16b">




Cures-
There are two cures to the problem - 
### First
We can perform unidirectional mapping-

    @OneToMany(targetEntity = DeviceEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_fk", referencedColumnName = "bill_id")
    private List<DeviceEntity> devices;
    

<img width="610" alt="Screenshot 2023-10-02 162330" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/798d2e89-88a4-4510-9ada-c02df3a991dd">



### Second
We can use native query in the JPA repository
    
     @Query(value = "update device_entity set bill_fk = :value1 where device_id = :value2",nativeQuery = true)
     void addForeignKey(@Param("value1") Long value1,@Param("value2") Long value2);
     

<img width="591" alt="Screenshot 2023-10-02 162500" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/8f692b6a-2cc6-4b92-8879-c32ee975e192">


## Understanding while approaching the problem-

@JoinColumn annotation while bi-directional mapping is creating foreign key constraint but hibernate is not writing update query. During unidirectional mapping hibernate is smartly inserting values in the table considering foreign key constraint and writing update query by itself which is tackled using native query as shown above.

<img width="404" alt="Screenshot 2023-10-02 163301" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/847f1205-6739-4b5d-864f-6eb0bb6473a5">




A more efficient solution to the problem will be appreciated.




                           

                            




