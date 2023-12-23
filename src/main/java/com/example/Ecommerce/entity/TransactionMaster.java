package com.example.Ecommerce.entity;

import java.sql.Timestamp;

import com.example.Ecommerce.Enum.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction_master")
public class TransactionMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name = "transaction_value")
	private String transactionValue;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "order_id_fk")
	private Long orderIdFk;
	
	@Column(name = "transaction_date")
	private Timestamp trasactionDate;
	
	@Column(name = "transaction_status")
	private PaymentStatus transactionStatus;

		

}
