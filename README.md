# Spring Security Auth Starter

> A security-focused, opinionated Spring Boot authentication and authorization foundation for REST APIs.

`spring-security-auth-starter` is a reusable Spring Boot starter for building authentication and authorization into modern applications without redesigning the same security primitives from scratch.

The project focuses not only on making authentication work, but on making the underlying **security decisions, trust boundaries, failure cases, and trade-offs explicit and testable**.

> **Status:** Under active development — currently building `v0.1.0: Authentication Foundation`.

---

## Why This Project Exists

AI-assisted development has made functional application code increasingly easy to generate. Authentication and authorization remain security-sensitive engineering problems. An implementation can compile, pass the happy path, and appear correct while still containing weaknesses in token validation, session lifecycle, credential recovery, authorization boundaries, or abuse protection.

This project provides an intentionally designed baseline built around:

* secure and opinionated defaults
* explicit trust boundaries
* documented security decisions and threat assumptions
* Spring Security-native mechanisms
* minimal custom security infrastructure
* positive and negative security testing
* production-oriented configuration patterns

The goal is not to replace security review or engineering judgment. **It is to provide a stronger place to start.**

---

## Current Release

### `v0.1.0 — Authentication Foundation`

Establishes core authentication trust boundary: persisted user accounts → Spring Security authentication → JWT access tokens → Resource Server validation → protected endpoints.

**Scope:** password hashing, credential authentication, short-lived JWT issuance, signature/issuer/audience validation, stateless API security, generic failure responses, unit and integration tests.

**Deferred:** refresh tokens, registration, email verification, password recovery, RBAC, login throttling, MFA.

See [`ROADMAP.md`](./ROADMAP.md) for complete development plan.

---

## Security Model

**Authentication:** Spring Security (AuthenticationManager → DaoAuthenticationProvider → UserDetailsService + PasswordEncoder). Passwords never stored in plaintext. Generic failure responses reduce account enumeration.

**Access Tokens:** Short-lived signed JWT with iss, sub, aud, iat, exp claims. Bearer credentials requiring cryptographic and claim validation before trust.

**Resource Protection:** Spring Security OAuth2 Resource Server for bearer-token processing and JWT validation. No custom JWT filter—framework-native security preferred.

---

## Tech Stack

**Core:** 

`Java`, `Spring Boot`, `Spring Security`, `Spring Security OAuth2 Resource Server`, `PostgreSQL`, `Flyway`

**Security:** 

`Spring Security` authentication, `JWT` access tokens, `Spring Security JOSE/JWT`, password hashing

**Quality:** 

`Maven`, `JUnit`

---

## Getting Started

**Prerequisites:** Java, Maven, PostgreSQL

**Setup:**
```bash
git clone https://github.com/leonardogendo/spring-security-auth-starter.git
cd spring-security-auth-starter
```

**Configuration:** Security-sensitive configuration must be externalized. `.env.example` will provide required configuration names without real credentials. Never commit passwords, database credentials, JWT signing secrets, private keys, or API credentials.

Detailed setup instructions will be added as the configuration model stabilizes.

---

## Testing

Negative security behavior is a first-class testing requirement. 

Authentication foundation tests: valid credentials, invalid password, unknown user, missing/malformed/tampered/expired JWT, invalid signature, wrong issuer/audience. 

A security control is not complete simply because its happy path works.

---

## Documentation

Security and architecture documentation will live under `docs/` as capabilities are implemented: 
- architecture.md
- authentication-model.md
- token-model.md
- authorization-model.md
- threat-model.md
- security-decisions.md
- deployment-security.md

Documentation focuses on both **how** and **why**.

---

## Security Notice

This repository provides a security-focused starting point, not a universal authentication solution. 

Security requirements vary by application, client type, deployment environment, threat model, and regulatory context. 

Before production use: 
- Review threat model
- Configure secrets and key management appropriately
- Validate deployment-specific security controls
- Perform application-specific security testing

Cloning this repository does not remove the need for security review.

---

## References

Security decisions informed by: 
- Spring Security Reference Documentation
- OWASP Authentication/Password Storage/Session Management/Authorization Cheat Sheets

---

## Maintainer

**Leonard Ogendo** — Secure Software Engineer | Application Security
