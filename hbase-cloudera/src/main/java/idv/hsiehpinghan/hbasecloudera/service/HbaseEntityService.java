package idv.hsiehpinghan.hbasecloudera.service;

import idv.hsiehpinghan.hbasecloudera.entity.HbaseGetEntity;
import idv.hsiehpinghan.hbasecloudera.entity.HbasePutEntity;
import idv.hsiehpinghan.hbasecloudera.repository.HbaseEntityRepository;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HbaseEntityService {
	@Autowired
	private HbaseEntityRepository repository;

	public HbaseGetEntity get(String rowKey) throws IOException {
		return repository.get(rowKey);
	}

	public boolean put(HbasePutEntity entity) {
		return repository.put(entity);
	}

	public boolean puts(Collection<HbasePutEntity> entities) {
		return repository.puts(entities);
	}
}
