import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Todo {
    private int id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private String status;
    private String reminderEmail;

    public Todo(int id, String title, String description, LocalDate creationDate, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.reminderEmail = null;
    }

    public String getReminderEmail() {
        return reminderEmail;
    }

    public void setReminderEmail(String reminderEmail) {
        this.reminderEmail = reminderEmail;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class TodoList {
    private static List<Todo> todos;
    private static Scanner scanner;

    public TodoList() {
        this.todos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addTodo(String title, String description, LocalDate creationDate, String status) {
        int id = generateId();
        Todo todo = new Todo(id, title, description, creationDate, status);
        todos.add(todo);
    }

    public static Todo getTodoById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    private boolean isOlderThanFiveDays(LocalDate creationDate) {
        LocalDate today = LocalDate.now();
        LocalDate fiveDaysAgo = today.minusDays(5);
        return creationDate.isBefore(fiveDaysAgo);
    }

    public static boolean setReminderEmail(int id, String email) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setReminderEmail(email);
            return true;
        }
        return false;
    }
    

    private static void sendReminderEmail() {
        System.out.println("\n===== Enviar E-mail de Lembrete =====");
        System.out.print("Digite o ID da tarefa para enviar o e-mail de lembrete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
    
        Todo todo = TodoList.getTodoById(id);
        if (todo != null) {
            if (todo.getReminderEmail() != null) {
                System.out.print("Digite o e-mail para enviar o lembrete: ");
                String email = scanner.nextLine();
    
                
                TodoList.setReminderEmail(id, email);
                System.out.println("E-mail de lembrete configurado para: " + email);
            } else {
                System.out.println("O e-mail de lembrete não foi configurado para esta tarefa.");
            }
        } else {
            System.out.println("Tarefa não encontrada com o ID fornecido.");
        }
    }
    
    
    
    

    private int generateId() {
        return todos.size() + 1;
    }

    public boolean updateTodo(int id, String newTitle, String newDescription) {
        Todo todo = getTodoById(id);
        if (todo != null && !todo.getStatus().equals("completed")) {
            todo.setTitle(newTitle);
            todo.setDescription(newDescription);
            return true;
        }
        return false;
    }

    public boolean deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id && todo.getStatus().equals("pending") && isOlderThanFiveDays(todo.getCreationDate())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateTodoStatus(int id, String newStatus) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setStatus(newStatus);
            return true;
        }
        return false;
    }

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos);
    }

    public List<Todo> getTodosByStatus(String status) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getStatus().equalsIgnoreCase(status)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public boolean deleteOldTodos() {
        Iterator<Todo> iterator = todos.iterator();
        boolean deleted = false;
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getStatus().equals("pending") && isOlderThanFiveDays(todo.getCreationDate())) {
                iterator.remove();
                deleted = true;
            }
        }
        return deleted;
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public void sendReminderEmail(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'sendReminderEmail'");
    }
}

public class Main {
    private static TodoList todoList = new TodoList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
        scanner.close();
    }

    private static void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Editar Tarefa");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Mudar Status da Tarefa");
            System.out.println("5. Listar Todas as Tarefas");
            System.out.println("6. Listar Tarefas por Status");
            System.out.println("7. Remover Tarefas Antigas");
            System.out.println("8. Enviar E-mail de Lembrete");
            System.out.println("9. Sair");

            System.out.print("\nEscolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    changeTaskStatus();
                    break;
                case 5:
                    listAllTasks();
                    break;
                case 6:
                    listTasksByStatus();
                    break;
                case 7:
                    removeOldTasks();
                    break;
                case 8:
                    sendReminderEmail();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
        System.out.println("Encerrando o programa.");
        todoList.closeScanner();
    }

    private static void addTask() {
        System.out.println("\n===== Adicionar Tarefa =====");
        System.out.print("Digite o título da tarefa: ");
        String title = scanner.nextLine();

        System.out.print("Digite a descrição da tarefa: ");
        String description = scanner.nextLine();

        LocalDate creationDate = LocalDate.now();
        String status = "pending";

        todoList.addTodo(title, description, creationDate, status);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    private static void editTask() {
        System.out.println("\n===== Editar Tarefa =====");
        System.out.print("Digite o ID da tarefa que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Todo todo = todoList.getTodoById(id);
        if (todo != null) {
            System.out.print("Digite o novo título da tarefa: ");
            String newTitle = scanner.nextLine();

            System.out.print("Digite a nova descrição da tarefa: ");
            String newDescription = scanner.nextLine();

            boolean updated = todoList.updateTodo(id, newTitle, newDescription);
            if (updated) {
                System.out.println("Tarefa atualizada com sucesso.");
            } else {
                System.out.println("Não foi possível atualizar a tarefa ou ela está concluída.");
            }
        } else {
            System.out.println("Tarefa não encontrada com o ID fornecido.");
        }
    }

    private static void deleteTask() {
        System.out.println("\n===== Remover Tarefa =====");
        System.out.print("Digite o ID da tarefa que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = todoList.deleteTodo(id);
        if (deleted) {
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Não foi possível remover a tarefa ou ela não está pendente ou foi criada há menos de 5 dias.");
        }
    }

    private static void changeTaskStatus() {
        System.out.println("\n===== Mudar Status da Tarefa =====");
        System.out.print("Digite o ID da tarefa que deseja mudar o status: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Todo todo = todoList.getTodoById(id);
        if (todo != null) {
            System.out.print("Digite o novo status da tarefa (pending, in progress, completed): ");
            String newStatus = scanner.nextLine();

            boolean updated = todoList.updateTodoStatus(id, newStatus);
            if (updated) {
                System.out.println("Status da tarefa atualizado com sucesso.");
            } else {
                System.out.println("Não foi possível atualizar o status da tarefa.");
            }
        } else {
            System.out.println("Tarefa não encontrada com o ID fornecido.");
        }
    }

    private static void listAllTasks() {
        List<Todo> allTodos = todoList.getAllTodos();
        if (allTodos.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
        } else {
            System.out.println("\n===== Lista de Todas as Tarefas =====");
            for (Todo todo : allTodos) {
                System.out.println("ID: " + todo.getId() + ", Título: " + todo.getTitle() + ", Descrição: " + todo.getDescription() + ", Data de Criação: " + todo.getCreationDate() + ", Status: " + todo.getStatus());
            }
        }
    }

    private static void listTasksByStatus() {
        System.out.println("\n===== Listar Tarefas por Status =====");
        System.out.print("Digite o status das tarefas que deseja listar (pending, in progress, completed): ");
        String status = scanner.nextLine();

        List<Todo> filteredTodos = todoList.getTodosByStatus(status);
        if (filteredTodos.isEmpty()) {
            System.out.println("\nNão há tarefas com o status '" + status + "'.");
        } else {
            System.out.println("\n===== Lista de Tarefas com Status '" + status + "' =====");
            for (Todo todo : filteredTodos) {
                System.out.println("ID: " + todo.getId() + ", Título: " + todo.getTitle() + ", Descrição: " + todo.getDescription() + ", Data de Criação: " + todo.getCreationDate());
            }
        }
    }

    private static void removeOldTasks() {
        boolean deleted = todoList.deleteOldTodos();
        if (deleted) {
            System.out.println("\nTarefas pendentes criadas há mais de 5 dias foram removidas com sucesso.");
        } else {
            System.out.println("\nNão há tarefas pendentes criadas há mais de 5 dias para remover.");
        }
    }

    private static void sendReminderEmail() {
        System.out.println("\n===== Enviar E-mail de Lembrete =====");
        System.out.print("Digite o ID da tarefa para enviar o e-mail de lembrete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
    
        Todo todo = todoList.getTodoById(id);
        if (todo != null) {
            if (todo.getReminderEmail() != null) {
                System.out.print("Digite o e-mail para enviar o lembrete: ");
                String email = scanner.nextLine();
    
                
                todoList.setReminderEmail(id, email);
                System.out.println("E-mail de lembrete configurado para: " + email);
            } else {
                System.out.println("O e-mail de lembrete não foi configurado para esta tarefa.");
            }
        } else {
            System.out.println("Tarefa não encontrada com o ID fornecido.");
        }
    }
    
    
}
