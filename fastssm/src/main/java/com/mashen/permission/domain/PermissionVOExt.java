package com.mashen.permission.domain;

import java.util.Set;

public class PermissionVOExt extends PermissionVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6115265793235445105L;
	private Set<PermissionVOExt> subPermissionVO;
	public int getSize(){
		if(subPermissionVO == null){
			return 0;
		}else{
			return subPermissionVO.size();
		}
		
		
	}
	public Set<PermissionVOExt> getSubPermissionVO() {
		return subPermissionVO;
	}

	public void setSubPermissionVO(Set<PermissionVOExt> subPermissionVO) {
		this.subPermissionVO = subPermissionVO;
	}
	 @Override
	    public boolean equals(Object that) {
	        if (this == that) {
	            return true;
	        }
	        if (that == null) {
	            return false;
	        }
	        if (getClass() != that.getClass()) {
	            return false;
	        }
	        PermissionVO other = (PermissionVO) that;
	        return (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()));
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
	        return result;
	    }

		@Override
		public String toString() {
			
			return super.toString();
		}

}
