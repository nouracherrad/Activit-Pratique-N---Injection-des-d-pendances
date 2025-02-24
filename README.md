# Injection de Dépendances 

## Description
Ce projet illustre différentes méthodes d'injection de dépendances en Java, permettant de mieux comprendre le couplage faible entre les composants. Il propose plusieurs approches d'injection :
- **Injection statique** : via le constructeur et le setter
- **Injection dynamique** : via la réflexion et un fichier de configuration
- **Injection avec Spring** : 
  - **Basée sur un fichier XML**
  - **Basée sur les annotations**

L'architecture du projet repose sur une stratégie modulaire comprenant une interface `IDao` et ses implémentations, une couche métier `IMetier`, et une couche de présentation responsable de l'exécution.

## Objectifs
- Comprendre le concept d'injection de dépendances
- Explorer différentes manières de réduire le couplage entre les classes
- Implémenter et comparer les approches statiques, dynamiques et celles basées sur Spring

## Structure du projet
- **`Dao`** : Contient l'interface `IDao` et ses implémentations (`DaoImpl`, `DaoImplV2`)
- **`Metier`** : Contient l'interface `IMetier` et son implémentation `MetierImpl`
- **`Pres` (Présentation)** : Contient plusieurs classes de présentation testant les différents types d'injection
- **Fichiers de configuration** :
  - `config.txt` : Spécifie les classes à charger dynamiquement
  - `config.xml` : Configure l'injection avec Spring XML

## Approches d'Injection de Dépendances

### 1. Injection statique
L'injection se fait directement dans le code source via le constructeur ou le setter.

- **Injection par constructeur** :
  ```java
  MetierImpl metier = new MetierImpl(new DaoImplV2());
  ```
- **Injection par setter** :
  ```java
  MetierImpl metier = new MetierImpl();
  metier.setDao(new DaoImplV2());
  ```

### 2. Injection dynamique avec la réflexion
Cette approche utilise `Class.forName()` pour instancier dynamiquement les classes dont les noms sont stockés dans `config.txt`.

### 3. Injection avec Spring XML
L'injection est configurée via un fichier `config.xml` contenant :
```xml
<bean id="dao" class="Dao.DaoImpl"/>
<bean id="metier" class="Metier.MetierImpl">
    <property name="dao" ref="dao"/>
</bean>
```
Le contexte est ensuite chargé via :
```java
ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
IMetier metier = context.getBean("metier", IMetier.class);
```

### 4. Injection avec Spring et annotations
L'injection est automatisée avec les annotations suivantes :
- `@Repository("dao")` sur `DaoImpl`
- `@Service("metier")` sur `MetierImpl`
- `@Autowired` pour récupérer automatiquement une instance de `IDao`

Le contexte est chargé avec :
```java
ApplicationContext context = new AnnotationConfigApplicationContext("Dao", "Metier");
IMetier metier = context.getBean("metier", IMetier.class);
```

## Instructions pour l'exécution
1. **Cloner ce repository**
2. **Tester les différentes approches** :
   - Exécuter `presentation1` pour l'injection statique
   - Exécuter `presentation2` avec `config.txt` pour l'injection dynamique
   - Exécuter `presentationAvecSpringXml` pour l'injection Spring XML
   - Exécuter `presSpringAvecAnnotation` pour l'injection avec annotations

## Diagramme de Classes
![image](https://github.com/user-attachments/assets/dd7d3a22-59c6-4eb3-aed8-b168d7fa87ac)


