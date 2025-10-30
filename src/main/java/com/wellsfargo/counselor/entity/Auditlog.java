package com.example.finadvisor.entities;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "entity_type", nullable = false)
    private String entityType; // e.g., ADVISOR, CLIENT, PORTFOLIO, SECURITY

    @Column(name = "entity_id", nullable = false)
    private String entityId; // store as string to be generic

    @Column(nullable = false)
    private String action; // CREATE, UPDATE, DELETE

    @Column(name = "performed_by")
    private Long performedBy; // advisor id who performed action

    @Column(name = "performed_at")
    private Instant performedAt;

    @Column(columnDefinition = "text")
    private String details; // JSON or text payload with more info

    public AuditLog() { }

    public AuditLog(String entityType, String entityId, String action, Long performedBy, Instant performedAt, String details) {
        this.entityType = entityType;
        this.entityId = entityId;
        this.action = action;
        this.performedBy = performedBy;
        this.performedAt = performedAt;
        this.details = details;
    }

    // Getters
    public Long getId() { return id; }

    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public Long getPerformedBy() { return performedBy; }
    public void setPerformedBy(Long performedBy) { this.performedBy = performedBy; }

    public Instant getPerformedAt() { return performedAt; }
    public void setPerformedAt(Instant performedAt) { this.performedAt = performedAt; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}