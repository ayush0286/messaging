//package com.messaging.app.service;
//
//import com.messaging.app.model.Group;
//import com.messaging.app.model.UserGroup;
//import com.messaging.app.enums.UserGroupStatus;
//import com.messaging.app.repository.GroupRepository;
//import com.messaging.app.repository.UserGroupRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//
//import java.util.Optional;
//
//@Service
//public class GroupService {
//
//    @Autowired
//    GroupRepository groupRepository;
//
//    @Autowired
//    UserGroupRepository userGroupRepository;
//
//    public String joinGroup(long userId, long groupId) throws Exception {
//        Group group = verifyGroupExistenceAndGetGroup(groupId);
//        if (!ObjectUtils.isEmpty(group)) {
//            UserGroup userGroup = new UserGroup();
//            userGroup.setGroupId(groupId);
//            userGroup.setUserId(userId);
//            userGroup.setStatus(UserGroupStatus.JOINED.name());
//            userGroupRepository.save(userGroup);
//            return "User added to group:" + group.getGroupName();
//        }
//        throw new Exception("Group Not Found");
//
//    }
//
//    private Group verifyGroupExistenceAndGetGroup(long groupId) {
//        Optional<Group> optionalGroup = groupRepository.findById(groupId);
//        if (optionalGroup.isPresent())
//            return optionalGroup.get();
//        return null;
//    }
//
//    public void leaveGroup(long userId, long groupId) throws Exception {
//        UserGroup userGroup = userGroupRepository.findByUserIdAndGroupId(userId, groupId);
//        if (ObjectUtils.isEmpty(userGroup) || userGroup.getStatus().equals(UserGroupStatus.LEFT.name())) {
//            throw new Exception("User not found in the group");
//        }
//        userGroup.setStatus(UserGroupStatus.LEFT.name());
//        userGroupRepository.save(userGroup);
//    }
//}
