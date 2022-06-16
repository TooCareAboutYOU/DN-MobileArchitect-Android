package com.dn.mobile.architect.lsn5.bean

import com.dn.mobile.architect.lsn5.anno.DbField
import com.dn.mobile.architect.lsn5.anno.DbTable

/**
 * @author zhangshuai
 * @date 2022/6/15 星期三
 * @email zhangshuai@dushu365.com
 * @description
 */
@DbTable(value = "tb_user")
class User() {
    @DbField("_id")
    var id: Int = -1
    var name: String = ""
    var password: String = ""


    constructor(id: Int, name: String, password: String) : this() {
        this.id = id
        this.name = name
        this.password = password
    }
}