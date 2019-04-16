package com.andrevitoria.sgm;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andrevitoria.sgm.domain.Attachment;
import com.andrevitoria.sgm.domain.Characteristic;
import com.andrevitoria.sgm.domain.Classification;
import com.andrevitoria.sgm.domain.Contract;
import com.andrevitoria.sgm.domain.Document;
import com.andrevitoria.sgm.domain.Protocol;
import com.andrevitoria.sgm.domain.enums.AttachmentStatus;
import com.andrevitoria.sgm.domain.enums.CharacteristicType;
import com.andrevitoria.sgm.domain.enums.ProtocolStatus;
import com.andrevitoria.sgm.repositories.AttachmentRepository;
import com.andrevitoria.sgm.repositories.CharacteristicRepository;
import com.andrevitoria.sgm.repositories.ClassificationRepository;
import com.andrevitoria.sgm.repositories.ContractRepository;
import com.andrevitoria.sgm.repositories.DocumentRepository;
import com.andrevitoria.sgm.repositories.ProtocolRepository;

@SpringBootApplication
public class SgmApplication implements CommandLineRunner {

	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private ContractRepository contractRepository;
	@Autowired
	private ClassificationRepository classificationRepository;
	@Autowired
	private CharacteristicRepository characteristicRepository;
	@Autowired
	private ProtocolRepository protocolRepository;
	@Autowired
	private AttachmentRepository attachmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SgmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Document do1 = new Document(null, "CN", false, new Date(), null);
		Document do2 = new Document(null, "GFIP", false, new Date(), null);

		Contract co1 = new Contract("CT03162014");
		Contract co2 = new Contract("CT00012014");

		co1.getDocuments().addAll(Arrays.asList(do1, do2));
		co2.getDocuments().addAll(Arrays.asList(do2));
		do1.getContracts().addAll(Arrays.asList(co1));
		do2.getContracts().addAll(Arrays.asList(co1, co2));

		documentRepository.saveAll(Arrays.asList(do1, do2));
		contractRepository.saveAll(Arrays.asList(co1, co2));

		Classification ca1 = new Classification(null, "Atributos Obrigatórios");
		Characteristic ch1 = new Characteristic(null, "Data de Emissão", CharacteristicType.INTERGER, true, ca1);
		Characteristic ch2 = new Characteristic(null, "Data de Validade", CharacteristicType.INTERGER, true, ca1);
		ca1.getCharacteristics().addAll(Arrays.asList(ch1, ch2));

		classificationRepository.saveAll(Arrays.asList(ca1));
		characteristicRepository.saveAll(Arrays.asList(ch1, ch2));

		Document do3 = new Document(null, "Antecedentes Criminais", false, new Date(), ca1);
		documentRepository.saveAll(Arrays.asList(do3));

		Protocol pr1 = new Protocol("2018.000001", 201901, ProtocolStatus.CLOSED);
		Protocol pr2 = new Protocol("2019.000001", 201901, ProtocolStatus.OPENED);
		Protocol pr3 = new Protocol("2019.000002", 201901, ProtocolStatus.OPENED);
		protocolRepository.saveAll(Arrays.asList(pr1, pr2, pr3));

		Attachment at1 = new Attachment(null, "dcc.docx", 0, AttachmentStatus.SENDED, new Date(), pr1, do1, co1);
		Attachment at2 = new Attachment(null, "dcc.docx", 0, AttachmentStatus.SENDED, new Date(), pr1, do1, co1);
		Attachment at3 = new Attachment(null, "dcc.docx", 0, AttachmentStatus.SENDED, new Date(), pr1, do1, co1);
		attachmentRepository.saveAll(Arrays.asList(at1, at2, at3));
	}

}
