@Service
public class InMemoryEmployeeService implements EmployeeService {

    private final List<Employee> employees = new CopyOnWriteArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.stream()
            .filter(e -> e.getUuid().equals(uuid))
            .findFirst()
            .orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setUuid(UUID.randomUUid());
        employees.add(employee);
        return employee;
    }
}