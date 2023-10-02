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

<img width="389" alt="image" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/6d92d6e2-d716-4aaf-a22d-b02286f15ba7">




Hibernate is creating foreign key but the column has null value as shown above. Following queries are written by Hibernate

<img width="842" alt="image" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/e29cc5ee-33f5-4e10-b5eb-fda258d4f052">


<img width="579" alt="image" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/fd7d4f17-729c-4001-b57b-912df7743997">


Cures-
There are two cures to the problem - 
### First
We can perform unidirectional mapping-

    @OneToMany(targetEntity = DeviceEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_fk", referencedColumnName = "bill_id")
    private List<DeviceEntity> devices;
    
<img width="591" alt="image" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/84a2814f-4913-4f70-b280-f6ad3806ef69">



### Second
We can use native query in the JPA repository
    
     @Query(value = "update device_entity set bill_fk = :value1 where device_id = :value2",nativeQuery = true)
     void addForeignKey(@Param("value1") Long value1,@Param("value2") Long value2);
     

<img width="610" alt="image" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/a73b3257-a2b7-44fc-b046-366bd04e354d">

## Understanding while approaching the problem-

@JoinColumn annotation while bi-directional mapping is creating foreign key constraint but hibernate is not writing update query. During unidirectional mapping hibernate is smartly inserting values in the table considering foreign key constraint and writing update query by itself which is tackled using native query as shown above.

<img width="404" alt="image" src="https://github.com/zubain86/mapping_errorhandling/assets/96322986/ee23508c-bb75-42c4-b7d7-099e7dbd11bc">



A more efficient solution to the problem will be appreciated.




                           

                            




