# whatToWatch
Initial Project for a system to enroll the medias I want to watch and organize them.

First Version of the project was made using Python (Flask and SQLAlquimy)

This second version is using Java (Vue.js), still the first version of the java project

Reinforcing concepts:

        Vue.js = framework

        Structure Maven:

                Controller: controller API REST - it manages the endpoints HTTP so Vue.js can interact
                Entity: model of data - it's a model for the data that will map the table of the database
                Repo: repository JPA - an interface that inherits the JPARepository so it can obtain the methods CRUD already done

        Lombok: it is used to generate the setter and getters, standart constructor and the constructor with the other args
            import 
                lombok.Getter
                lombor.Setter
                lombok.NoArgsConstructor
                lombok.AllArgsConstructor
