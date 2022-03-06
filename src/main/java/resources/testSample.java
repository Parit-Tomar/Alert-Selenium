package resources;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
	public String Rules;
	public String MetricGroup;
	public String MetricName;
	public String ConditionType;
	public String TriggerWhen;
	public String CriticalThreshold;
	public String MajorThreshold;
	public String MinorThreshold;
	public String RuleName;
	public String getRules() {
		return Rules;
	}
	public void setRules(String rules) {
		Rules = rules;
	}
	public String getMetricGroup() {
		return MetricGroup;
	}
	public void setMetricGroup(String metricGroup) {
		MetricGroup = metricGroup;
	}
	public String getMetricName() {
		return MetricName;
	}
	public void setMetricName(String metricName) {
		MetricName = metricName;
	}
	public String getConditionType() {
		return ConditionType;
	}
	public void setConditionType(String conditionType) {
		ConditionType = conditionType;
	}
	public String getTriggerWhen() {
		return TriggerWhen;
	}
	public void setTriggerWhen(String triggerWhen) {
		TriggerWhen = triggerWhen;
	}
	public String getCriticalThreshold() {
		return CriticalThreshold;
	}
	public void setCriticalThreshold(String criticalThreshold) {
		CriticalThreshold = criticalThreshold;
	}
	public String getMajorThreshold() {
		return MajorThreshold;
	}
	public void setMajorThreshold(String majorThreshold) {
		MajorThreshold = majorThreshold;
	}
	public String getMinorThreshold() {
		return MinorThreshold;
	}
	public void setMinorThreshold(String minorThreshold) {
		MinorThreshold = minorThreshold;
	}
	public String getRuleName() {
		return RuleName;
	}
	public void setRuleName(String ruleName) {
		RuleName = ruleName;
	}
	@Override
	public String toString() {
		return "testSample [Rules=" + Rules + ", MetricGroup=" + MetricGroup + ", MetricName=" + MetricName
				+ ", ConditionType=" + ConditionType + ", TriggerWhen=" + TriggerWhen + ", CriticalThreshold="
				+ CriticalThreshold + ", MajorThreshold=" + MajorThreshold + ", MinorThreshold=" + MinorThreshold
				+ ", RuleName=" + RuleName + ", getRules()=" + getRules() + ", getMetricGroup()=" + getMetricGroup()
				+ ", getMetricName()=" + getMetricName() + ", getConditionType()=" + getConditionType()
				+ ", getTriggerWhen()=" + getTriggerWhen() + ", getCriticalThreshold()=" + getCriticalThreshold()
				+ ", getMajorThreshold()=" + getMajorThreshold() + ", getMinorThreshold()=" + getMinorThreshold()
				+ ", getRuleName()=" + getRuleName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
