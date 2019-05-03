package com.andrevitoria.sgm.services;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.andrevitoria.sgm.domain.Attachment;
import com.andrevitoria.sgm.domain.Contract;
import com.andrevitoria.sgm.domain.Document;
import com.andrevitoria.sgm.domain.Protocol;
import com.andrevitoria.sgm.domain.dto.AttachmentNewDto;
import com.andrevitoria.sgm.domain.enums.AttachmentStatus;
import com.andrevitoria.sgm.repositories.AttachmentRepository;

@Service
public class AttachmentService {
	@Autowired
	private AttachmentRepository repo;
	@Autowired
	private ProtocolService ps;
	@Autowired
	private DocumentService ds;
	@Autowired
	private ContractService cs;

	@Transactional
	public Attachment insert(Attachment obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	public Optional<Attachment> find(Integer id) {
		return repo.findById(id);
	}

	public Attachment fromDTO(AttachmentNewDto objDto, MultipartFile file) throws IOException {
		Protocol objProtocol = ps.find(objDto.getId_protocol());
		Document objDocument = ds.find(objDto.getId_document());
		Contract objContract = cs.find(objDto.getId_contract());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		Attachment objAttachment = new Attachment(null, fileName, file.getBytes(), file.getContentType(), AttachmentStatus.SENDED, new Date(),
				objProtocol, objDocument, objContract);

		return objAttachment;
	}
}
