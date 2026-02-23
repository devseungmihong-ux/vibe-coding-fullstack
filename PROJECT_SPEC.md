# 프로젝트 명세서: vibeapp (최소 기능 스프링부트 애플리케이션)

이 문서는 최소 기능을 갖춘 스프링부트 기반 웹 애플리케이션 프로젝트인 **vibeapp**의 기술 명세 및 설정을 정의합니다.

---

## 1. 프로젝트 개요
- **프로젝트 명**: vibeapp
- **설명**: 최소 기능 스프링부트 애플리케이션을 생성하기 위한 기본 템플릿 프로젝트입니다.
- **주요 목표**: 필수 설정만을 포함하여 가볍고 빠른 시작이 가능한 구조를 제공합니다.

---

## 2. 프로젝트 설정 (Environment)
| 항목 | 사양 |
| :--- | :--- |
| **JDK** | JDK 25 이상 |
| **Language** | Java |
| **Spring Boot** | 4.0.1 이상 |
| **Build Tool** | Gradle 9.2.0 이상 |
| **Build Script** | Groovy DSL (`build.gradle`) |
| **Configuration** | YAML (`application.yml`) |

---

## 3. 프로젝트 메타데이터 (Metadata)
- **Group**: `com.example`
- **Artifact**: `vibeapp`
- **Package Name**: `com.example.vibeapp`
- **Main Class**: `VibeApp` (또는 `VibeAppApplication`)
- **Version**: `0.0.1-SNAPSHOT`

---

## 4. 빌드 설정 및 의존성
### 4.1 플러그인 (Plugins)
- `org.springframework.boot` (Spring Boot 기반)
- `io.spring.dependency-management` (Spring Boot 버전에 맞춘 의존성 관리)
- `java` (Java 지원)

### 4.2 의존성 (Dependencies)
- **최소 기능 프로젝트**: 추가적인 외부 라이브러리 없이 Spring Boot Starter만 포함합니다.
    - `implementation 'org.springframework.boot:spring-boot-starter-web'` (Web 환경인 경우)
    - *사용자 요청에 따라 추가 의존성 없음 (최소 기능)*

---

## 5. 설정 파일 (Configuration)
`src/main/resources/application.yml` 파일을 사용하여 설정을 관리합니다.

```yaml
spring:
  application:
    name: vibeapp
  profiles:
    active: dev

server:
  port: 8080
```

---

## 6. 특징 및 유의사항
- **최신 스택 사용**: JDK 25 및 Spring Boot 4.0.1+ 등의 최신 기술 스택을 지향합니다.
- **단순성 유지**: 복잡한 의존성 없이 핵심 기능만을 포함하여 유지보수가 용이합니다.
