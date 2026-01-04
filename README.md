## Requirements:

### 1. Project & Issue Hierarchy

* **Requirement:** Users can create multiple **Projects**. Every **Issue** (Task, Bug, Story) must belong to a project and be assigned to a **User**.
* **JPA Focus:** Implement `One-to-Many` (Project ↔ Issues) and `Many-to-One` (Issue ↔ Assignee). Use DTOs to avoid circular dependencies.

### 2. Flexible Issue Types & Metadata

* **Requirement:** Support different issue types (e.g., **BUG**, **STORY**, **TASK**). Each issue should have a priority (LOW, MEDIUM, HIGH) and a unique key (e.g., `PROJ-123`).
* **JPA Focus:** Use `@Enumerated(EnumType.STRING)` for Types and Priorities. Implement a custom logic in your Service layer to auto-increment the issue key per project.

### 3. Workflow State Management

* **Requirement:** An issue must have a **Status** (OPEN, IN_PROGRESS, IN_REVIEW, DONE). Users should be able to update the status, but you must prevent invalid transitions (e.g., moving directly from `OPEN` to `DONE` might be blocked).
* **Spring Focus:** Implement a simple **State Pattern** or a transition validator service.

### 4. Sprint Management

* **Requirement:** Create **Sprints** within a project. Users can "assign" issues to a sprint. An issue can belong to only one active sprint at a time.
* **JPA Focus:** Manage the `Many-to-Many` or `One-to-Many` relationship between Sprints and Issues. Ensure that when a sprint is marked "Completed," all unfinished issues move back to the **Backlog**.

### 5. Searching & Filtering (The "Mini-JQL")

* **Requirement:** Provide an API to filter issues by: *Project, Assignee, Status, or Type.*
* **JPA Focus:** Use **Spring Data JPA Specifications** or `QueryDSL`. This is much more "machine-coding-pro" than writing 10 different findBy methods.
