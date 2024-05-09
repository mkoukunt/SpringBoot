package org.rabini.fraudservice;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {
	@jakarta.persistence.Id
	@SequenceGenerator(name="fraud_id_sequence",sequenceName = "fraud_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "fraud_id_sequence")
	private Integer Id;
	private Integer customerId;
	private Boolean isdFraudster;
	private LocalDateTime createdAt;
	
}
