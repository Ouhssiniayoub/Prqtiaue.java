import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskTrackerApp {
    private static List<Group> groups = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Создать группу");
            System.out.println("2. Удалить группу");
            System.out.println("3. Добавить студента");
            System.out.println("4. Удалить студента");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createGroup(scanner);
                    break;
                case 2:
                    removeGroup(scanner);
                    break;
                case 3:
                    addStudent(scanner);
                    break;
                case 4:
                    removeStudent(scanner);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод. Повторите попытку.");
            }
        }
    }

    private static void createGroup(Scanner scanner) {
        System.out.println("Введите название группы:");
        String groupName = scanner.next();
        groups.add(new Group(groupName));
        System.out.println("Группа создана.");
    }

    private static void removeGroup(Scanner scanner) {
        System.out.println("Введите название группы для удаления:");
        String groupToRemove = scanner.next();
        groups.removeIf(group -> group.getGroupName().equals(groupToRemove));
        System.out.println("Группа удалена.");
    }

    private static void addStudent(Scanner scanner) {
        System.out.println("Введите название группы для добавления студента:");
        String groupToAddStudent = scanner.next();
        Group selectedGroup = findGroup(groupToAddStudent);

        if (selectedGroup != null) {
            System.out.println("Введите имя студента:");
            String studentName = scanner.next();
            selectedGroup.addStudent(new Student(studentName));
            System.out.println("Студент добавлен.");
        } else {
            System.out.println("Группа не найдена.");
        }
    }

    private static void removeStudent(Scanner scanner) {
        System.out.println("Введите название группы для удаления студента:");
        String groupToRemoveStudent = scanner.next();
        Group selectedGroupToRemove = findGroup(groupToRemoveStudent);

        if (selectedGroupToRemove != null) {
            System.out.println("Введите имя студента:");
            String studentToRemove = scanner.next();
            selectedGroupToRemove.getStudents().removeIf(student -> student.getName().equals(studentToRemove));
            System.out.println("Студент удален.");
        } else {
            System.out.println("Группа не найдена.");
        }
    }

    private static Group findGroup(String groupName) {
        return groups.stream()
                .filter(group -> group.getGroupName().equals(groupName))
                .findFirst().orElse(null);
    }
}