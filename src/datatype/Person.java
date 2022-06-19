package datatype;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person (Person person) {
        this.name = person.name;
        this.age = person.age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;

        Person otherObj = (Person) obj;

        if (age != otherObj.age)
            return false;
        if (name == null) {
            if (otherObj.name != null) {
                return false;
            }
        } else if (!name.equals(otherObj.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + age;
        result = result * prime + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(age, otherPerson.age);
    }

    @Override
    public String toString() {
        return "" + age;
    }
}
