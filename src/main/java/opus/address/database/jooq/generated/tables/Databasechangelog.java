/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.0"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Databasechangelog extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.Databasechangelog> {

	private static final long serialVersionUID = 1918202972;

	/**
	 * The reference instance of <code>databasechangelog</code>
	 */
	public static final opus.address.database.jooq.generated.tables.Databasechangelog Databasechangelog = new opus.address.database.jooq.generated.tables.Databasechangelog();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.Databasechangelog> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.Databasechangelog.class;
	}

	/**
	 * The column <code>databasechangelog.id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Id = createField("id", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>databasechangelog.author</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Author = createField("author", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>databasechangelog.filename</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Filename = createField("filename", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>databasechangelog.dateexecuted</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.sql.Timestamp> Dateexecuted = createField("dateexecuted", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>databasechangelog.orderexecuted</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.Integer> Orderexecuted = createField("orderexecuted", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>databasechangelog.exectype</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Exectype = createField("exectype", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false), this, "");

	/**
	 * The column <code>databasechangelog.md5sum</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Md5sum = createField("md5sum", org.jooq.impl.SQLDataType.VARCHAR.length(35), this, "");

	/**
	 * The column <code>databasechangelog.description</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Description = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>databasechangelog.comments</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Comments = createField("comments", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>databasechangelog.tag</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Tag = createField("tag", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>databasechangelog.liquibase</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Databasechangelog, java.lang.String> Liquibase = createField("liquibase", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

	/**
	 * Create a <code>databasechangelog</code> table reference
	 */
	public Databasechangelog() {
		this("databasechangelog", null);
	}

	/**
	 * Create an aliased <code>databasechangelog</code> table reference
	 */
	public Databasechangelog(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.Databasechangelog.Databasechangelog);
	}

	private Databasechangelog(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.Databasechangelog> aliased) {
		this(alias, aliased, null);
	}

	private Databasechangelog(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.Databasechangelog> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.Databasechangelog as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.Databasechangelog(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.Databasechangelog rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.Databasechangelog(name, null);
	}
}
