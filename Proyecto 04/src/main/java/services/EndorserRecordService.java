
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.EndorserRecordRepository;
import security.LoginService;
import security.UserAccount;
import domain.EndorserRecord;

@Service
@Transactional
public class EndorserRecordService {

	// Manged Repository

	@Autowired
	private EndorserRecordRepository	endorserRecordRepository;


	// Simple CRUD methods

	public EndorserRecord create(final EndorserRecord endorserRecord) {

		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Assert.isTrue(userAccount.getAuthorities().contains("HANDYWORKER"));
		this.endorserRecordRepository.save(endorserRecord);

		return endorserRecord;

	}

	public Collection<EndorserRecord> findAll() {
		Collection<EndorserRecord> result;

		result = this.endorserRecordRepository.findAll();

		return result;
	}
	public EndorserRecord findOne(final Integer id) {
		final EndorserRecord result = this.endorserRecordRepository.findOne(id);
		return result;
	}

	public void save(final EndorserRecord endorserRecord) {
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Assert.isTrue(userAccount.getAuthorities().contains("HANDYWORKER"));
		this.endorserRecordRepository.save(endorserRecord);
	}

	public void delete(final EndorserRecord endorserRecord) {
		this.endorserRecordRepository.delete(endorserRecord);
	}

}
