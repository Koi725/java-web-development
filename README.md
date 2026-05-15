# ☕ Java Web Development — Practice Projects

> A collection of Java web service projects built from scratch, progressing from beginner to advanced. Perfect for university students preparing for **Web Services / Integration Technologies** exams.

## 🎯 What You'll Learn

- **REST APIs** with Jetty + Jersey (JAX-RS)
- **SOAP Services** with Spring Boot + JAXB
- **XML & XSD** schemas and data contracts
- Full **CRUD operations** (GET, POST, PUT, DELETE)
- `@PathParam` vs `@QueryParam` filtering
- Multi-resource APIs with business logic
- JSON serialization with Gson

## 📁 Project Progression

| # | Project | Difficulty | Topics Covered |
|---|---------|-----------|----------------|
| 1 | Pet Clinic (REST + SOAP) | ⭐⭐⭐ | First full project — learn the complete flow |
| 2 | Bookstore | ⭐⭐ | Simple GET + POST |
| 3 | Music Playlist | ⭐⭐ | GET + POST + DELETE |
| 4 | Car Dealership | ⭐⭐⭐ | Full CRUD with PUT |
| 5 | Hospital Patients | ⭐⭐⭐ | `@QueryParam` search + filtering |
| 6 | Restaurant Orders | ⭐⭐⭐⭐ | 7 endpoints, status updates, complex logic |
| 7 | E-Commerce Store | ⭐⭐⭐⭐⭐ | Two resources, stock management, business logic |
| 8 | Gym Members | ⭐⭐ | Review — GET, POST, DELETE |
| 9 | Movie Collection | ⭐⭐⭐ | Review — full CRUD |
| 10 | Hotel Booking | ⭐⭐⭐⭐ | Boolean filters, book/release endpoints |

## 🛠️ Tech Stack

- **Java 17+**
- **Maven** — build & dependency management
- **Jetty** — embedded web server (REST projects)
- **Jersey** — JAX-RS implementation (REST framework)
- **Gson** — JSON ↔ Java conversion
- **Spring Boot** — SOAP projects
- **JAXB** — XSD → Java class generation
- **WSDL4J** — WSDL auto-generation

## 🚀 How to Run Any REST Project

```bash
# 1. Navigate to the project folder
cd project2/project2-rest

# 2. Compile and run
mvn compile exec:java -Dexec.mainClass="ti.exame.Main"

# 3. Test in another terminal
curl http://localhost:8001/your-endpoint
```

## 🧼 How to Run Any SOAP Project

```bash
# 1. Navigate to the project folder
cd project1/project1-soap

# 2. Compile and run
mvn clean compile spring-boot:run

# 3. Check the WSDL
curl http://localhost:8002/services/your-service.wsdl

# 4. Send a SOAP request
curl -X POST http://localhost:8002/services \
  -H "Content-Type: text/xml" \
  -d '<?xml version="1.0"?>
  <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Body>
      <yourRequest xmlns="https://exame.ti/soap">
        <field>value</field>
      </yourRequest>
    </soap:Body>
  </soap:Envelope>'
```

## 📝 The Standard REST Recipe (3 files)

```
YourModel.java       → data class (fields + getters/setters + empty constructor)
YourResource.java    → REST endpoints (@Path, @GET, @POST, @PUT, @DELETE)
Main.java            → Jetty server startup (template — barely changes)
pom.xml              → dependencies (copy from any REST project)
```

## 📝 The Standard SOAP Recipe (6 files)

```
schemaWs.xsd                → define Request + Response (XSD)
mvn compile                 → JAXB generates Java classes from XSD
Exercicio1Application.java  → Spring Boot starter (always the same)
WebServiceConfig.java       → WSDL configuration (template — change 3 values)
YourEndpoint.java           → SOAP logic (@Endpoint, @PayloadRoot)
application.properties      → server.port=8002
```

## 🧠 Key Annotations Cheat Sheet

### REST (JAX-RS)
| Annotation | What it does |
|-----------|-------------|
| `@Path("/resource")` | Sets the URL path |
| `@GET` `@POST` `@PUT` `@DELETE` | HTTP method |
| `@Produces(APPLICATION_JSON)` | Response format |
| `@Consumes(APPLICATION_JSON)` | Request format |
| `@PathParam("id")` | Extract from URL: `/resource/123` |
| `@QueryParam("key")` | Extract from query: `/resource?key=value` |

### SOAP (Spring WS)
| Annotation | What it does |
|-----------|-------------|
| `@Endpoint` | Marks class as SOAP handler |
| `@PayloadRoot(namespace, localPart)` | Maps to XSD request element |
| `@ResponsePayload` | Method returns SOAP response |
| `@RequestPayload` | Method parameter is SOAP request |

## 📌 Common Mistakes to Avoid

- **Missing empty constructor** in model class → Gson/JAXB crashes
- **Typos in class names** → Java is case-sensitive (`Servlet` ≠ `Servelet`)
- **`@PathParam` vs `@QueryParam`** → path = in URL, query = after `?`
- **`gson.fromJson()` vs `gson.toJson()`** → from = JSON→Java, to = Java→JSON
- **`private` list in resource** → use `static` or data resets per request
- **Missing `Content-Type` header** in curl POST/PUT requests

## 👨‍🎓 Who Is This For?

University students studying Integration Technologies, Web Services, or similar courses. These projects simulate the type of practical exams where you build a working web service from scratch in 2-3 hours.

## 📄 License

Free to use for learning purposes. Built while preparing for university exams.
