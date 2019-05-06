def parse_room(room):
  return [['#' if c == '#' else '.' for c in line] 
          for line in room.strip().split('\n')]

def get_vector(dir):
  dirs = [
    (0, -1),
    (1, 0),
    (0, 1),
    (-1, 0)
  ]

  return dirs[dir]

class Robot(object):
  def __init__(self, room, x, y):
    self.room = room
    self.dir = 0
    self.x = x
    self.y = y

    self.depth = -1

  def move(self):
    dx, dy = get_vector(self.dir)
    x, y = self.x + dx, self.y + dy
    invalid = (
        y < 0 or y >= len(self.room) or
        x < 0 or x >= len(self.room[y]) or
        self.room[y][x] == '#'
    )
    if invalid:
      self.print_msg('move (failed)')
      self.print_state()
      return False

    self.x = x
    self.y = y
    self.print_msg('move')
    self.print_state()
    return True

  def turn_left(self):
    self.dir = (self.dir-1)%4
    self.print_msg('turn left')
    self.print_state()

  def turn_right(self):
    self.dir = (self.dir+1)%4
    self.print_msg('turn right')
    self.print_state()

  def clean(self):
    self.room[self.y][self.x] = ' '

  def is_clean(self):
    return self.room[self.y][self.x] == ' '

  def push(self):
    self.depth += 1

  def pop(self):
    self.depth -= 1

  def print_state(self):
    room = [list(line) for line in self.room]
    dirs = ['^', '>', 'V', '<']
    dir_char = dirs[self.dir]
    room[self.y][self.x] = dir_char

    for line in room:
      print '  '*self.depth + ''.join(line)

    print

  def print_msg(self, msg):
    print '  '*self.depth + msg

def clean(robot):
  robot.push()
  robot.print_msg('<clean>')

  if robot.is_clean():
    robot.print_msg('already clean')
    robot.print_msg('</clean>')
    robot.print_msg('')
    robot.pop()

    return

  robot.print_msg('')

  robot.clean()

  for i in range(4):
    robot.print_msg('i: %d' % i)

    if robot.move():
      clean(robot)
      robot.print_msg('going backwards')
      robot.turn_right()
      robot.turn_right()
      robot.move()
      robot.turn_right()
      robot.turn_right()

    robot.print_msg('end of i: %d' % i)
    robot.turn_right()

  robot.print_msg('</clean>')
  robot.print_msg('')

  robot.pop()

# room = """
# ###########
# ##   ######
# #     #####
# # ###     #
# # #########
# ###########
# """

room = """
###########
###########
#  ########
###########
"""
room = parse_room(room)

robot = Robot(room, 2, 2)
robot.print_msg('initial state:')
robot.print_msg('')
robot.print_state()
clean(robot)
