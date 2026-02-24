# 프로젝트 명세서: vibeapp (기능 중심 커뮤니티 애플리케이션)

이 문서는 게시판 및 홈 페이지 기능을 갖춘 스프링부트 기반 웹 애플리케이션 프로젝트인 **vibeapp**의 기술 명세 및 설정을 정의합니다.

---

## 1. 프로젝트 개요
- **프로젝트 명**: vibeapp
- **설명**: 기능별 패키지 구조를 갖춘 게시판 중심의 커뮤니티 애플리케이션입니다.
- **주요 목표**: 확장성 있는 패키지 구조와 현대적인 UI/UX 기술을 적용한 웹 서비스를 제공합니다.

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

## 3. 프로젝트 아키텍처 (Architecture)
### 3.1 패키지 구조 (Feature-based)
- `com.example.vibeapp.home`: 홈 페이지 및 일반 API 관련 로직
- `com.example.vibeapp.post`: 게시글 관련 도메인, 서비스, 저장소 및 컨트롤러
- `com.example.vibeapp`: 메인 애플리케이션 진입점

### 3.2 뷰 템플릿 구조
- `src/main/resources/templates/home/`: 홈 페이지 관련 템플릿
- `src/main/resources/templates/post/`: 게시글 조회, 작성, 수정 관련 템플릿

---

## 4. 빌드 설정 및 의존성
### 4.1 플러그인 (Plugins)
- `org.springframework.boot`
- `io.spring.dependency-management`
- `java`

### 4.2 의존성 (Dependencies)
- `spring-boot-starter-web`: 웹 MVC 개발용
- `spring-boot-starter-thymeleaf`: Thymeleaf 템플릿 엔진 지원

---

## 5. UI 및 기술 사양
- **Frontend Framework**: Thymeleaf + Tailwind CSS
- **Design Enhancements**:
    - **Pagination**: 5개씩 페이징 처리, 하단 고정형 네비게이션 바 적용
    - **Icons**: Lucide 기반의 SVG 아이콘 활용 (Material Symbols 대체)
    - **Responsiveness**: 고해상도 환경에 최적화된 컴팩트한 레이아웃

---

## 6. 특징 및 유의사항
- **기능 중심 구조**: 기능별로 패키지와 템플릿이 분리되어 유지보수가 용이합니다.
- **최신 스택 사용**: JDK 25 및 Spring Boot 4.0.1+ 기반의 환경에서 최적화되었습니다.
- **RESTful Naming**: 컨트롤러 메서드 명칭이 `getPosts`, `createPost` 등 직관적인 관례를 따릅니다.
