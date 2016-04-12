package idv.hsiehpinghan.hbasecloudera.entity;

import java.util.Arrays;

import org.apache.hadoop.hbase.util.Bytes;

public class HbaseEntityBase implements Comparable<HbaseEntityBase> {
	public static final byte[] TABLE_NAME = Bytes.toBytes("UDR");
	public static final byte[] COLUMN_FAMILY_NAME = Bytes.toBytes("f");
	private byte[] rowKey;

	public HbaseEntityBase(byte[] rowKey) {
		super();
		this.rowKey = rowKey;
	}

	public byte[] getRowKey() {
		return rowKey;
	}

	public String getRowKeyString() {
		return Bytes.toString(rowKey);
	}

	public void setRowKey(String rowKey) {
		this.rowKey = Bytes.toBytes(rowKey);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(rowKey);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.compareTo((HbaseEntityBase) obj) == 0;
	}

	@Override
	public int compareTo(HbaseEntityBase obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			return 1;
		return getRowKeyString().compareTo(obj.getRowKeyString());
	}

}
