# 1
Давайте создадим класс PersonEntry. У него будет два поля:  
 - Person person  
 - Integer value  
ну т.е. в одном поле будет хранится сам person,  
 - а в другом - сколько раз этот person встретился в списке. 

Теперь представьте, у вас есть метод  
Set<PersonEntry> countPerson(List<Person> list)    
который считает, сколько раз Person встретился в данном листе,   
создает PersonEntry, и возвращает сет из PersonEntry ну, т.е. так

Исходный List:  
List<Person> list1 = List.of(  
new Person("Jack", 12),  
new Person("John", 22),  
new Person("Jack", 12),  
new Person("Jack", 12)  
);  

Результат сет из двух объектов PersonEntry:  
PersonEntry{Person("Jack", 12),3}  
PersonEntry{Person("John", 22),1}  


Ваша задача написать тесты для этого метода  

# 2
Естественно, желающие могут реализовать сам метод
