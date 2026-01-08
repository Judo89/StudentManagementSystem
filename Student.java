public class Student {

        private int id;
        private String name;
        private int age;
        private String major;

        public Student(int id, String name, int age, String major) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.major = major;
        }

        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setMajor(String major) {
            this.major = major;
        }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }


    @Override
        public String toString() {
            return "ID: " + id +
                    ", Name: " + name +
                    ", Age: " + age +
                    ", Major: " + major;
        }

}
