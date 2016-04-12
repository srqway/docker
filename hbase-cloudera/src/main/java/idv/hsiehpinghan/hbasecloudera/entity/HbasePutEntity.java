package idv.hsiehpinghan.hbasecloudera.entity;

import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.hbase.util.Bytes;

public class HbasePutEntity extends HbaseEntityBase {

	private ColumnFamily columnFamily;

	public HbasePutEntity(String rowKey, Map<String, String> columnFamilyMap) {
		super(Bytes.toBytes(rowKey));
		columnFamily = new ColumnFamily(columnFamilyMap);
	}

	public ColumnFamily getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(ColumnFamily columnFamily) {
		this.columnFamily = columnFamily;
	}

	public static class ColumnFamily {
		public static final String VALUE = "ec_etmall";
		private Map<String, String> cf;

		public ColumnFamily(Map<String, String> cf) {
			super();
			this.cf = cf;
		}

		public byte[] getValue() {
			String value = getValueString();
			return value == null ? null : Bytes.toBytes(value);
		}

		public String getValueString() {
			Map<String, String> cf = getCf();
			return cf.get(VALUE);
		}

		public void setValue(byte[] value) {
			getCf().put(VALUE, Bytes.toString(value));
		}

		public void setValueString(String value) {
			getCf().put(VALUE, value);
		}

		private Map<String, String> getCf() {
			if (cf == null) {
				cf = new TreeMap<String, String>();
			}
			return cf;
		}
	}

}
