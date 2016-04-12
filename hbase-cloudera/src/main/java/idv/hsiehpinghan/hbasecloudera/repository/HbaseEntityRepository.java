package idv.hsiehpinghan.hbasecloudera.repository;

import idv.hsiehpinghan.hbasecloudera.entity.HbaseEntityBase;
import idv.hsiehpinghan.hbasecloudera.entity.HbaseGetEntity;
import idv.hsiehpinghan.hbasecloudera.entity.HbasePutEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NavigableMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HbaseEntityRepository {
	@Autowired
	private Configuration config;

	public HbaseGetEntity get(String rowKey) throws IOException {
		HTable hTable = getHTable();
		byte[] RowKeyBytes = Bytes.toBytes(rowKey);
		Get get = getGet(RowKeyBytes);
		Result result = hTable.get(get);
		NavigableMap<byte[], byte[]> columnFamilyMap = result
				.getFamilyMap(HbaseEntityBase.COLUMN_FAMILY_NAME);
		HbaseGetEntity entity = new HbaseGetEntity(RowKeyBytes, columnFamilyMap);
		return entity;
	}

	public boolean put(HbasePutEntity entity) {
		HTable hTable = null;
		try {
			hTable = getHTable();
			Put put = getPut(entity);
			hTable.put(put);
			hTable.close();
			return true;
		} catch (IOException e) {
			if (hTable != null) {
				try {
					hTable.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return false;
		}
	}

	public boolean puts(Collection<HbasePutEntity> entities) {
		List<Put> puts = new ArrayList<>(entities.size());
		HTable hTable = null;
		for (HbasePutEntity entity : entities) {
			Put put = getPut(entity);
			puts.add(put);
		}
		try {
			hTable = getHTable();
			hTable.put(puts);
			hTable.close();
			return true;
		} catch (IOException e) {
			if (hTable != null) {
				try {
					hTable.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return false;
		}
	}

	private Put getPut(HbasePutEntity entity) {
		Put put = new Put(entity.getRowKey());
		put.add(HbaseEntityBase.COLUMN_FAMILY_NAME, Bytes
				.toBytes(HbasePutEntity.ColumnFamily.VALUE), entity
				.getColumnFamily().getValue());
		return put;
	}

	private Get getGet(byte[] rowKey) {
		Get get = new Get(rowKey);
		return get;
	}

	private HTable getHTable() throws IOException {
		HTable hTable = new HTable(config, HbaseEntityBase.TABLE_NAME);
		return hTable;
	}
}
