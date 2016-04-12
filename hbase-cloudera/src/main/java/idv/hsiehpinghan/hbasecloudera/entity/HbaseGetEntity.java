package idv.hsiehpinghan.hbasecloudera.entity;

import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.hbase.util.Bytes;

public class HbaseGetEntity extends HbaseEntityBase {
	private ColumnFamily columnFamily;

	public HbaseGetEntity(byte[] rowKey, Map<byte[], byte[]> columnFamilyMap) {
		super(rowKey);
		columnFamily = new ColumnFamily(columnFamilyMap);
	}

	public ColumnFamily getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(ColumnFamily columnFamily) {
		this.columnFamily = columnFamily;
	}

	public static class ColumnFamily {
		public static final byte[] VALUE = Bytes.toBytes("ec_etmall");
		private Map<byte[], byte[]> cf;

		public ColumnFamily(Map<byte[], byte[]> cf) {
			super();
			this.cf = cf;
		}

		public byte[] getValue() {
			Map<byte[], byte[]> cf = getCf();
			if (cf.containsKey(VALUE) == false) {
				return null;
			}
			return cf.get(VALUE);
		}

		public String getValueString() {
			byte[] value = getValue();
			return value == null ? null : Bytes.toString(value);
		}

		public void setValue(byte[] value) {
			getCf().put(VALUE, value);
		}

		public void setValueString(String value) {
			getCf().put(VALUE, Bytes.toBytes(value));
		}

		private Map<byte[], byte[]> getCf() {
			if (cf == null) {
				cf = new TreeMap<byte[], byte[]>();
			}
			return cf;
		}
	}

}
