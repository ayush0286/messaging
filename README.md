# messaging
A simple, reliable, messaging app to test out HLD concepts


https://towardsdatascience.com/ace-the-system-interview-design-a-chat-application-3f34fd5b85d0
https://kasunprageethdissanayake.medium.com/whatsapp-system-design-and-chat-messaging-architecture-part-1-29fb4f0d14af
https://codepen.io/ankitjain28/pen/WRvaZG

Requirement:
Direct messaging: two users can chat with each other
Group chat: users can participate in group conversations
Join/leave groups, (add/delete friends not important for Slack)
Typing indicator: when typing, the recipient gets notified
User status: whether you are online or offline
When the user is offline, try send notifications to the user’s mobile device if a new message arrives.
temp:
Save msgs till sent

DB Schema::
-----------
-----------

User:
	user_name, phone_number,created_at,,updated_at,created_by,updated_by
UserChat:
	user_one, user_two, chat_id_user_to_user,created_at
PrivateMessage:
	content, seenAt, sentAt,msg_status deliveredAt,message_sequence_id, chat_id_user_to_user, sent_by_user_id, sent_for_id



Group:
	group_name, created_at, updated_at, created_by, updated_by, description
UserGroup:
	group_id, user_id, user_status,added_by,removed_by, added_at, removed_at, version
GroupMessage:
	group_id,content,message_sequence_id, sent_by_user_id, msg_status
GroupMessageDesciption:
	group_message_id, seenAt, sentAt, deliveredAt, user_id, msg_status


APIS:
WebService::
	Register User: Done
	Login User : Done
	Search User for chat : Done(Only user registered users can be searched for chat)
	Fetch All chat info: one to one, group -> name, lastMsg, timestamp, msgStatus
	Fetch one to  one chat
	Save user chat

	Create/Delete Group
	Add/Leave Group
	Edit Group Description
	Fetch Group chat
	Fetch msg descrption: one2one/group:: get_messages(user_id, user_id2, channel_type, earliest_message_id)

ChatService::
	OnetoOne chat: private chat and update user
	Group Chat: broad cast to chat and update user
	send_message(user_id, receiver_id, channel_type, message)

