package com.mashen.demo1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DemoVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DemoVOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTestidIsNull() {
            addCriterion("testid is null");
            return (Criteria) this;
        }

        public Criteria andTestidIsNotNull() {
            addCriterion("testid is not null");
            return (Criteria) this;
        }

        public Criteria andTestidEqualTo(Integer value) {
            addCriterion("testid =", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotEqualTo(Integer value) {
            addCriterion("testid <>", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidGreaterThan(Integer value) {
            addCriterion("testid >", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidGreaterThanOrEqualTo(Integer value) {
            addCriterion("testid >=", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLessThan(Integer value) {
            addCriterion("testid <", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLessThanOrEqualTo(Integer value) {
            addCriterion("testid <=", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidIn(List<Integer> values) {
            addCriterion("testid in", values, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotIn(List<Integer> values) {
            addCriterion("testid not in", values, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidBetween(Integer value1, Integer value2) {
            addCriterion("testid between", value1, value2, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotBetween(Integer value1, Integer value2) {
            addCriterion("testid not between", value1, value2, "testid");
            return (Criteria) this;
        }

        public Criteria andTestnameIsNull() {
            addCriterion("testname is null");
            return (Criteria) this;
        }

        public Criteria andTestnameIsNotNull() {
            addCriterion("testname is not null");
            return (Criteria) this;
        }

        public Criteria andTestnameEqualTo(String value) {
            addCriterion("testname =", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotEqualTo(String value) {
            addCriterion("testname <>", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameGreaterThan(String value) {
            addCriterion("testname >", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameGreaterThanOrEqualTo(String value) {
            addCriterion("testname >=", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLessThan(String value) {
            addCriterion("testname <", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLessThanOrEqualTo(String value) {
            addCriterion("testname <=", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLike(String value) {
            addCriterion("testname like", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotLike(String value) {
            addCriterion("testname not like", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameIn(List<String> values) {
            addCriterion("testname in", values, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotIn(List<String> values) {
            addCriterion("testname not in", values, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameBetween(String value1, String value2) {
            addCriterion("testname between", value1, value2, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotBetween(String value1, String value2) {
            addCriterion("testname not between", value1, value2, "testname");
            return (Criteria) this;
        }

        public Criteria andTestsexIsNull() {
            addCriterion("testsex is null");
            return (Criteria) this;
        }

        public Criteria andTestsexIsNotNull() {
            addCriterion("testsex is not null");
            return (Criteria) this;
        }

        public Criteria andTestsexEqualTo(String value) {
            addCriterion("testsex =", value, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexNotEqualTo(String value) {
            addCriterion("testsex <>", value, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexGreaterThan(String value) {
            addCriterion("testsex >", value, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexGreaterThanOrEqualTo(String value) {
            addCriterion("testsex >=", value, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexLessThan(String value) {
            addCriterion("testsex <", value, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexLessThanOrEqualTo(String value) {
            addCriterion("testsex <=", value, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexLike(String value) {
            addCriterion("testsex like", value, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexNotLike(String value) {
            addCriterion("testsex not like", value, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexIn(List<String> values) {
            addCriterion("testsex in", values, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexNotIn(List<String> values) {
            addCriterion("testsex not in", values, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexBetween(String value1, String value2) {
            addCriterion("testsex between", value1, value2, "testsex");
            return (Criteria) this;
        }

        public Criteria andTestsexNotBetween(String value1, String value2) {
            addCriterion("testsex not between", value1, value2, "testsex");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIsNull() {
            addCriterion("lastmodifytime is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIsNotNull() {
            addCriterion("lastmodifytime is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeEqualTo(Date value) {
            addCriterion("lastmodifytime =", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotEqualTo(Date value) {
            addCriterion("lastmodifytime <>", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeGreaterThan(Date value) {
            addCriterion("lastmodifytime >", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastmodifytime >=", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeLessThan(Date value) {
            addCriterion("lastmodifytime <", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeLessThanOrEqualTo(Date value) {
            addCriterion("lastmodifytime <=", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIn(List<Date> values) {
            addCriterion("lastmodifytime in", values, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotIn(List<Date> values) {
            addCriterion("lastmodifytime not in", values, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeBetween(Date value1, Date value2) {
            addCriterion("lastmodifytime between", value1, value2, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotBetween(Date value1, Date value2) {
            addCriterion("lastmodifytime not between", value1, value2, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdIsNull() {
            addCriterion("creator_department_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdIsNotNull() {
            addCriterion("creator_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdEqualTo(String value) {
            addCriterion("creator_department_id =", value, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdNotEqualTo(String value) {
            addCriterion("creator_department_id <>", value, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdGreaterThan(String value) {
            addCriterion("creator_department_id >", value, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("creator_department_id >=", value, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdLessThan(String value) {
            addCriterion("creator_department_id <", value, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("creator_department_id <=", value, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdLike(String value) {
            addCriterion("creator_department_id like", value, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdNotLike(String value) {
            addCriterion("creator_department_id not like", value, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdIn(List<String> values) {
            addCriterion("creator_department_id in", values, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdNotIn(List<String> values) {
            addCriterion("creator_department_id not in", values, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdBetween(String value1, String value2) {
            addCriterion("creator_department_id between", value1, value2, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("creator_department_id not between", value1, value2, "creatorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdIsNull() {
            addCriterion("creator_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdIsNotNull() {
            addCriterion("creator_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdEqualTo(String value) {
            addCriterion("creator_user_id =", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdNotEqualTo(String value) {
            addCriterion("creator_user_id <>", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdGreaterThan(String value) {
            addCriterion("creator_user_id >", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("creator_user_id >=", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdLessThan(String value) {
            addCriterion("creator_user_id <", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdLessThanOrEqualTo(String value) {
            addCriterion("creator_user_id <=", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdLike(String value) {
            addCriterion("creator_user_id like", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdNotLike(String value) {
            addCriterion("creator_user_id not like", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdIn(List<String> values) {
            addCriterion("creator_user_id in", values, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdNotIn(List<String> values) {
            addCriterion("creator_user_id not in", values, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdBetween(String value1, String value2) {
            addCriterion("creator_user_id between", value1, value2, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdNotBetween(String value1, String value2) {
            addCriterion("creator_user_id not between", value1, value2, "creatorUserId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}