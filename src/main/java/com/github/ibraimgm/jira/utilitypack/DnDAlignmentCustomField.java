package com.github.ibraimgm.jira.utilitypack;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.AbstractSingleFieldType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.customfields.persistence.PersistenceFieldType;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.config.FieldConfig;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;

public class DnDAlignmentCustomField extends AbstractSingleFieldType<String> {
	private static final Logger	log	= LoggerFactory.getLogger(DnDAlignmentCustomField.class);

	public DnDAlignmentCustomField(CustomFieldValuePersister customFieldValuePersister,
			GenericConfigManager genericConfigManager) {
		super(customFieldValuePersister, genericConfigManager);
	}

	@Override
	public Map<String, Object> getVelocityParameters(final Issue issue, final CustomField field,
			final FieldLayoutItem fieldLayoutItem) {

		// call the default implementation and get out if we don't have a current issue
		final Map<String, Object> map = super.getVelocityParameters(issue, field, fieldLayoutItem);

		if (issue == null)
			return map;

		// if we DO have a issue, send extra data to the layout
		String s = (String) field.getValue(issue);
		map.put("w", s);

		if ((s != null) && (!s.isEmpty())) {
			map.put("lvc", s.substring(0, 1)); // Law vs Chaos
			map.put("gve", s.substring(1)); // Good vs Evil

			if (s.equals("LG")) {
				map.put("longDescription", "Lawful Good");
				map.put("color", "#B8860B");
			} else if (s.equals("LN")) {
				map.put("longDescription", "Lawful Neutral");
				map.put("color", "#8B4513");
			} else if (s.equals("LE")) {
				map.put("longDescription", "Lawful Evil");
				map.put("color", "#800000");
			} else if (s.equals("NG")) {
				map.put("longDescription", "Neutral Good");
				map.put("color", "#1E90FF");
			} else if (s.equals("NN")) {
				map.put("longDescription", "True Neutral");
				map.put("color", "#4682B4");
			} else if (s.equals("NE")) {
				map.put("longDescription", "Neutral Evil");
				map.put("color", "#6A5ACD");
			} else if (s.equals("CG")) {
				map.put("longDescription", "Chaotic Good");
				map.put("color", "#E9967A");
			} else if (s.equals("CN")) {
				map.put("longDescription", "Chaotic Neutral");
				map.put("color", "#CD5C5C");
			} else if (s.equals("CE")) {
				map.put("longDescription", "Chaotic Evil");
				map.put("color", "#B22222");
			}

		}

		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atlassian.jira.issue.customfields.CustomFieldType#getSingularObjectFromString(java.lang
	 * .String)
	 */
	@Override
	public String getSingularObjectFromString(String arg0) throws FieldValidationException {
		return arg0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atlassian.jira.issue.customfields.CustomFieldType#getStringFromSingularObject(java.lang
	 * .Object)
	 */
	@Override
	public String getStringFromSingularObject(String arg0) {
		return arg0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.atlassian.jira.issue.customfields.impl.AbstractSingleFieldType#getDatabaseType()
	 */
	@Override
	@Nonnull
	protected PersistenceFieldType getDatabaseType() {
		return PersistenceFieldType.TYPE_LIMITED_TEXT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atlassian.jira.issue.customfields.impl.AbstractSingleFieldType#getDbValueFromObject(java
	 * .lang.Object)
	 */
	@Override
	@Nullable
	protected Object getDbValueFromObject(String arg0) {
		return arg0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atlassian.jira.issue.customfields.impl.AbstractSingleFieldType#getObjectFromDbValue(java
	 * .lang.Object)
	 */
	@Override
	@Nullable
	protected String getObjectFromDbValue(@Nonnull Object arg0) throws FieldValidationException {
		if (arg0 != null)
			return (String) arg0;
		else
			return null;
	}
}